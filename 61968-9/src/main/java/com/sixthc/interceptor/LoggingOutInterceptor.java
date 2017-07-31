/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.sixthc.interceptor;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.cxf.common.injection.NoJSR250Annotations;
import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.interceptor.AbstractLoggingInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.interceptor.StaxOutInterceptor;
import org.apache.cxf.io.CacheAndWriteOutputStream;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.CachedOutputStreamCallback;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.springframework.beans.factory.annotation.Autowired;

import com.sixthc.dao.MessageLogDao;
import com.sixthc.dao.VendorDao;
import com.sixthc.model.MessageLog;
import com.sixthc.util.XmlStringParser;

/**
 * 
 */
@NoJSR250Annotations
public class LoggingOutInterceptor extends AbstractLoggingInterceptor {
	private String packageName = null;
	private String messageName = null;
	private String packageGroupName = null;
	private String resultCode = null;
	private String stage = null;
	private boolean strict = false;
	private static final Logger LOG = LogUtils
			.getLogger(LoggingOutInterceptor.class);
	private static final String LOG_SETUP = LoggingOutInterceptor.class
			.getName() + ".log-setup";
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(LoggingOutInterceptor.class);

	@Autowired
	private MessageLogDao messageLogDao;
	MessageLog messageLog = new MessageLog();

	@Autowired
	private VendorDao vendorDao;

	public LoggingOutInterceptor(String phase) {
		super(phase);
		addBefore(StaxOutInterceptor.class.getName());
	}

	public LoggingOutInterceptor() {
		this(Phase.PRE_STREAM);
	}

	public LoggingOutInterceptor(int lim) {
		this();
		limit = lim;
	}

	public LoggingOutInterceptor(PrintWriter w) {
		this();
		this.writer = w;
	}

	public void handleMessage(Message message) throws Fault {
		final OutputStream os = message.getContent(OutputStream.class);
		if (os == null) {
			return;
		}
		if (getLogger().isLoggable(Level.INFO) || writer != null) {
			// Write the output while caching it for the log message
			boolean hasLogged = message.containsKey(LOG_SETUP);
			if (!hasLogged) {
				message.put(LOG_SETUP, Boolean.TRUE);
				final CacheAndWriteOutputStream newOut = new CacheAndWriteOutputStream(
						os);
				message.setContent(OutputStream.class, newOut);
				newOut.registerCallback(new LoggingCallback(message, os));
			}
		}
	}

	class LoggingCallback implements CachedOutputStreamCallback {

		private final Message message;
		private final OutputStream origStream;

		public LoggingCallback(final Message msg, final OutputStream os) {
			this.message = msg;
			this.origStream = os;
		}

		public void onFlush(CachedOutputStream cos) {

		}

		public void onClose(CachedOutputStream cos) {

			log.debug("onClose");
			String id = (String) message.getExchange().get(
					LoggingMessage.ID_KEY);
			if (id == null) {
				id = LoggingMessage.nextId();
				message.getExchange().put(LoggingMessage.ID_KEY, id);
			}
			final LoggingMessage buffer = new LoggingMessage(
					"Outbound Message\n---------------------------", id);
			messageLog.setMessageId(id);

			// link up with correct interface
			messageLog.setPackageName(getPackageName());
			messageLog.setPackageGroupName(getPackageGroupName());
			messageLog.setMessageName(getMessageName());
			messageLog.setStage(stage);

			Integer responseCode = (Integer) message.get(Message.RESPONSE_CODE);
			if (responseCode != null) {
				messageLog.setResponseCode(String.valueOf(responseCode));
			}

			String encoding = (String) message.get(Message.ENCODING);

			if (encoding != null) {
				messageLog.setEncoding(encoding);
			}
			String httpMethod = (String) message
					.get(Message.HTTP_REQUEST_METHOD);
			if (httpMethod != null) {
				messageLog.setHttpMethod(httpMethod);
			}
			String address = (String) message.get(Message.ENDPOINT_ADDRESS);
			if (address != null) {
				buffer.getAddress().append(address);
			}
			String ct = (String) message.get(Message.CONTENT_TYPE);
			if (ct != null) {
				messageLog.setContentType(ct);
			}
			Object headers = message.get(Message.PROTOCOL_HEADERS);
			if (headers != null) {
				messageLog.setHeader(headers.toString());
			}

			// infer interface if not set
			if (messageName != null)
				messageLog.setMessageName(getMessageName());

			if (cos.getTempFile() == null) {
				// buffer.append("Outbound Message:\n");
				if (cos.size() > limit) {
					buffer.getMessage().append(
							"(message truncated to " + limit + " bytes)\n");
				}
			} else {
				buffer.getMessage().append(
						"Outbound Message (saved to tmp file):\n");
				buffer.getMessage().append(
						"Filename: " + cos.getTempFile().getAbsolutePath()
								+ "\n");
				if (cos.size() > limit) {
					buffer.getMessage().append(
							"(message truncated to " + limit + " bytes)\n");
				}
			}
			try {
				StringBuilder payload = new StringBuilder();

				writePayload(payload, cos, encoding, ct);
				buffer.getPayload().append(payload);
				String payloadString = payload.toString();
				messageLog.setPayload(payloadString);

				// special processing for each message type, CIM, MS...
				processPayload(new XmlStringParser(payloadString), messageLog);

				/*
				 * we require the header to contain User/Organization, and for
				 * the value to
				 * correspond to name attribute in vendor table, else we can't
				 * track who
				 * owns this message
				 */
				//				parser = new XmlStringParser(payloadString);
				//				String org = parser.getTagValue("http://www.iec.ch/TC57/2011/schema/message", "User", "Organization");
				//				log.debug("org : " + org);
				//				if( !StringUtils.isBlank(org)) {
				//					Vendor vendor = vendorDao.findByName(org);
				//					if( vendor != null ) {
				//						messageLog.setVendor(vendor);;
				//					} else{
				//						log.error("bad value for User/Organization passed : " + org + ". Cannot set vendor id");
				//					}
				//				} else {
				//					log.error("Unable to retrieve value for User/Organization. Cannot set vendor id");
				//				}
				//				
				//				/*
				//				 * We identify the vendor for the outgoing message by looking at
				//				 * the vendor associated with the incoming message
				//				 */
				//				String correlationID = parser.getHeaderValueWC("CorrelationID");
				//				log.debug("correlation ID : " + correlationID);
				//				if( !StringUtils.isBlank(correlationID)) {
				//					log.error("unexpected, correlation id not set");
				//				} else {
				//					MessageLog ml = messageLogDao.findByMessageID(correlationID);
				//					if( ml == null )
				//						log.error("Unable to retrieve message log using corrleation ID of " + correlationID);
				//					else
				//						messageLog.setVendor(ml.getVendor());
				//				}

			} catch (Exception ex) {
				// ignore
			}

			messageLog.setResultCode(resultCode);
			messageLogDao.save(messageLog);
			log(buffer.toString());
			try {
				// empty out the cache
				cos.lockOutputStream();
				cos.resetOut(null, false);
			} catch (Exception ex) {
				// ignore
			}
			message.setContent(OutputStream.class, origStream);
		}
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getMessageName() {
		return messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}

	public String getPackageGroupName() {
		return packageGroupName;
	}

	public void setPackageGroupName(String packageGroupName) {
		this.packageGroupName = packageGroupName;
	}

	/**
	 * Override this method if you wish to search for tags
	 * and react to values and such
	 * 
	 * @param payload
	 * @throws Fault
	 */
	public void processPayload(XmlStringParser payload, MessageLog messageLog)
			throws Fault {
	}

	public String inferMessage(String action) {
		return "";
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}

	public void setResultCode(String rc) {
		this.resultCode = rc;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public void setStrict(boolean strict) {
		this.strict = strict;
	}

	public boolean isStrict() {
		return this.strict;
	}

}
