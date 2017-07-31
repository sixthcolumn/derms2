package com.sixthc.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sixthc.dao.MessageLogDao;
import com.sixthc.model.MessageLog;
import com.sixthc.util.XmlStringParser;

public class CIMLoggingOutInterceptor extends LoggingOutInterceptor {

	@Autowired
	private MessageLogDao messageLogDao;

	private static org.apache.log4j.Logger log = Logger
			.getLogger(CIMLoggingOutInterceptor.class);

	@Override
	public void processPayload(XmlStringParser payload, MessageLog messageLog)
			throws Fault {

		/*
		 * get correlation ID from message and save
		 * it in the log
		 */
		String correlationID;
		try {
			correlationID = payload.getTagValue(
					"http://iec.ch/TC57/2011/schema/message",
					"CorrelationID");
		} catch (Exception e) {
			Fault fault = new Fault(e);
			throw fault;
		}

		log.debug("correlationID : " + correlationID);

		if (isStrict() == true && StringUtils.isBlank(correlationID)) {
			// CorrelationID CANNOT be empty/null
			log.error("header.CorrelationID is required");
			Fault fault = new Fault(new Exception(
					"CIM header.CorrelationID required"));
			throw fault;
		} else
			messageLog.setCorrelationID(correlationID);

		/*
		 * Find vendor id by doing lookup using correlationID
		 * on previous message log
		 */
		MessageLog inLog = messageLogDao.findByCorrelation(correlationID);
		if (inLog != null) {
			messageLog.setVendor(inLog.getVendor());
			messageLog.setMessage(inLog.getMessage());
		} else {
			Fault fault = new Fault(new Exception(
					"CorrelationID lookback failed for " + correlationID));
			throw fault;
		}

		/*
		 * Store the new message ID in the message log
		 */
		String messageID;
		try {
			messageID = payload.getTagValue(
					"http://iec.ch/TC57/2011/schema/message", "MessageID");

		} catch (Exception e) {
			Fault fault = new Fault(e);
			throw fault;
		}

		log.debug("messageID : " + messageID);

		if (isStrict() == true && StringUtils.isBlank(messageID)) {
			// MessageID CANNOT be empty/null
			log.error("header.message ID is required");
			Fault fault = new Fault(new Exception(
					"CIM header.MessageID required"));
			throw fault;
		} else if (isStrict() == true
				&& !messageLogDao.messageIDIsUnique(messageID)) {
			log.error("header.MessageID must be unique");
			Fault fault = new Fault(new Exception(
					"CIM header.MessageID is not unique"));
			throw fault;
		} else
			messageLog.setMessageId(messageID);
	}

	@Override
	public String inferMessage(String action) {
		String interfaceName = "unknownInterface";

		//change actions
		if (action.toLowerCase().contains("changedergroups"))
			interfaceName = "CIM_DER(changeExecuteDERGroups";
		else if (action.toLowerCase().contains("executedergroupsoperationset"))
			interfaceName = "CIM_DER(changeExecuteDERGroupsOperationSet)";
		else if (action.toLowerCase().contains("executeddergroupsoperationset"))
			interfaceName = "CIM_DER(changeExecuteDERGroupsOperationSet";
		else if (action.toLowerCase().contains("changeddergroupstatuses"))
			interfaceName = "CIM_DER(changeReceiveDERGroupStatuses)";
		// create actions
		else if (action.toLowerCase().contains("createdergroupdispatches"))
			interfaceName = "CIM_DER(createExecuteDERGroupDispatches)";
		else if (action.toLowerCase().contains("createdergroups"))
			interfaceName = "CIM_DER(createExecuteDERGroups)";
		else if (action.toLowerCase().contains("createddergroupforecasts"))
			interfaceName = "CIM_DER(createReceiveDERGroupForecasts)";
		else if (action.toLowerCase().contains("createddergroups"))
			interfaceName = "CIM_DER(createReceiveDERGroups)";
		// get actions
		else if (action.toLowerCase().contains("querydergroupforecasts"))
			interfaceName = "CIM_DER(getQueryDERGroupForecasts)";
		else if (action.toLowerCase().contains("querydergroups"))
			interfaceName = "CIM_DER(getQueryDERGroups)";
		else if (action.toLowerCase().contains("querydergroupstatuses"))
			interfaceName = "CIM_DER(getQueryDERGroupStatuses)";
		// action not found
		else
			log.warn("Interface name for " + action + " not found");

		log.debug("infer Interface : action = " + action + ", inteface = "
				+ interfaceName);
		return interfaceName;
	}

}
