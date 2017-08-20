package com.sixthc.interceptor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Node;

import com.sixthc.dao.MessageDao;
import com.sixthc.model.Message;
import com.sixthc.util.MSHeader;
import com.sixthc.util.XMLUtil;

public class ReplaceMessageInterceptor extends MessageChangeInterceptor {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(ReplaceMessageInterceptor.class);

	// lookup message.name from database
	private String messageName;
	private String xsdFile;
	private String message;

	@Autowired
	private MessageDao messageDao;

	@Override
	protected Logger getLogger() {
		return log;
	}

	String headerTags[] = { "Timestamp", "MessageID", "CorrelationID" };

	@Override
	protected String changeOutboundMessage(String currentEnvelope) {
		String headerTags[] = { "Timestamp", "MessageID", "CorrelationID" };

		log.debug("executing changeOutboundMessage Interceptor");

		// get the message replacement header from db
		Message msg = messageDao.findByName(messageName);

		// if we get the replacement msg, then copy certain tag values from orig to this
		// message
		if (msg.getMsgReply() != null
				&& msg.getMsgReply().getMessageText() != null
				&& xsdFile != null) {

			// get the new envelope to return
			String newMsg = msg.getMsgReply().getMessageText();

			// try to replace  MessageID, CorrelationID, Timestamp
			try {
				XMLUtil soap = new XMLUtil(newMsg);
				Node n = soap.getNode("*", message);
				// validate the xml
				if (soap.isXMLValid(xsdFile, n)) {
					return MSHeader.CopyPaste(currentEnvelope, newMsg,
							headerTags);
				} 
			} catch (Exception e) {
				log.error(e);
			}
		}

		// if no replacement message defined, or tag replace failed, give them
		// back the msg returned by the tomcat axis2 app
		return currentEnvelope;
	}

	@Override
	protected String changeInboundMessage(String currentEnvelope) {
		log.debug("executing changeInboundMessage Interceptor");
		return currentEnvelope;
	}

	public String getMessageName() {
		return messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}

	public String getXsdFile() {
		return xsdFile;
	}

	public void setXsdFile(String xsdFile) {
		this.xsdFile = xsdFile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
