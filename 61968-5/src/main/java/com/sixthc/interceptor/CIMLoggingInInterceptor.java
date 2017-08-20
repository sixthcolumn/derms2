package com.sixthc.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sixthc.dao.MessageLogDao;
import com.sixthc.dao.VendorDao;
import com.sixthc.model.MessageLog;
import com.sixthc.model.Vendor;
import com.sixthc.util.XMLUtil;

public class CIMLoggingInInterceptor extends LoggingInInterceptor {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(CIMLoggingInInterceptor.class);

	@Autowired
	private MessageLogDao messageLogDao;

	@Autowired
	private VendorDao vendorDao;

	@Override
	public void processPayload(XMLUtil payload, MessageLog messageLog)
			throws Fault {

		/*
		 * we require the header to contain User/Organization, and for the value
		 * to
		 * correspond to name attribute in vendor table, else we can't track who
		 * owns this message
		 */
		String org;
		try {
			org = payload.getTagValue(
					"http://www.iec.ch/TC57/2011/schema/message", "User",
					"Organization");
		} catch (Exception e) {
			Fault fault = new Fault(e);
			throw fault;
		}

		log.debug("org : " + org);
		if (!StringUtils.isBlank(org)) {
			Vendor vendor = vendorDao.findByName(org);
			if (vendor != null) {
				messageLog.setVendor(vendor);
			} else {
				log.error("bad value for User/Organization passed : " + org
						+ ". Cannot set vendor id");
			}
		} else {
			log.error("Unable to retrieve value for User/Organization. Cannot set vendor id");
		}

		// get the MessageID from the payload
		String messageID;
		try {
			messageID = payload.getTagValue(
					"http://iec.ch/TC57/2011/schema/message", "MessageID");

		} catch (Exception e) {
			Fault fault = new Fault(e);
			throw fault;
		}

		log.debug("messageID : " + messageID);

		if (StringUtils.isBlank(messageID)) {
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
