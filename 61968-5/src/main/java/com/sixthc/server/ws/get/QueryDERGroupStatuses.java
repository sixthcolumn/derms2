package com.sixthc.server.ws.get;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sixthc.part5.get.QueryDERGroupStatuses.DERGroupStatusQueriesRequestMessageType;
import com.sixthc.part5.get.QueryDERGroupStatuses.DERGroupStatusQueriesResponseMessageType;
import com.sixthc.part5.get.QueryDERGroupStatuses.ErrorType;
import com.sixthc.part5.get.QueryDERGroupStatuses.HeaderType;
import com.sixthc.part5.get.QueryDERGroupStatuses.QueryDERGroupStatusesFaultMessage;
import com.sixthc.part5.get.QueryDERGroupStatuses.QueryDERGroupStatusesPort;
import com.sixthc.part5.get.QueryDERGroupStatuses.ReplyType;

public class QueryDERGroupStatuses implements QueryDERGroupStatusesPort,
		ApplicationContextAware {

	ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;
	}

	@Override
	public DERGroupStatusQueriesResponseMessageType queryDERGroupStatuses(
			DERGroupStatusQueriesRequestMessageType queryDERGroupStatusesRequestMessage)
			throws QueryDERGroupStatusesFaultMessage {
		
		DERGroupStatusQueriesResponseMessageType msg = new DERGroupStatusQueriesResponseMessageType();

		// give them their own messageID back as correlation id
		String messageID = queryDERGroupStatusesRequestMessage.getHeader().getMessageID();

		HeaderType header = appContext.getBean(
				"get_queryDERGroupStatuses_header", HeaderType.class);
		msg.setHeader(header);
		
		header.setCorrelationID(messageID);
				
		ReplyType reply = appContext.getBean(
		"get_queryDERGroupStatuses_reply", ReplyType.class);
		
		ErrorType error =  appContext.getBean(
				"get_queryDERGroupStatuses_error", ErrorType.class);
		reply.getError().clear();
		reply.getError().add(error);
		
		msg.setReply(reply);
				
		return msg;
		
	}
}
