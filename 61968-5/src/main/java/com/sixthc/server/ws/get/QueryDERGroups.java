package com.sixthc.server.ws.get;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sixthc.part5.get.QueryDERGroups.DERGroupQueriesRequestMessageType;
import com.sixthc.part5.get.QueryDERGroups.DERGroupQueriesResponseMessageType;
import com.sixthc.part5.get.QueryDERGroups.ErrorType;
import com.sixthc.part5.get.QueryDERGroups.HeaderType;
import com.sixthc.part5.get.QueryDERGroups.QueryDERGroupsFaultMessage;
import com.sixthc.part5.get.QueryDERGroups.QueryDERGroupsPort;
import com.sixthc.part5.get.QueryDERGroups.ReplyType;

public class QueryDERGroups implements QueryDERGroupsPort,
		ApplicationContextAware {

	ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;

	}

	@Override
	public DERGroupQueriesResponseMessageType queryDERGroups(
			DERGroupQueriesRequestMessageType queryDERGroupsRequestMessage)
			throws QueryDERGroupsFaultMessage {
		
		DERGroupQueriesResponseMessageType msg = new DERGroupQueriesResponseMessageType();

		// give them their own messageID back as correlation id
		String messageID = queryDERGroupsRequestMessage.getHeader().getMessageID();

		HeaderType header = appContext.getBean(
				"get_queryDERGroups_header", HeaderType.class);
		header.setCorrelationID(messageID);
		
		msg.setHeader(header);
		
		ReplyType reply = appContext.getBean(
		"get_queryDERGroups_reply", ReplyType.class);
		
		ErrorType error =  appContext.getBean(
				"get_queryDERGroups_error", ErrorType.class);
		reply.getError().add(error);
		
		msg.setReply(reply);
				
		return msg;

	}

}
