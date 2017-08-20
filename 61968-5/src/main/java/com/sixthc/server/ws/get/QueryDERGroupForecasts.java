package com.sixthc.server.ws.get;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sixthc.part5.get.QueryDERGroupForecasts.DERGroupForecastQueriesRequestMessageType;
import com.sixthc.part5.get.QueryDERGroupForecasts.DERGroupForecastQueriesResponseMessageType;
import com.sixthc.part5.get.QueryDERGroupForecasts.ErrorType;
import com.sixthc.part5.get.QueryDERGroupForecasts.HeaderType;
import com.sixthc.part5.get.QueryDERGroupForecasts.QueryDERGroupForecastsFaultMessage;
import com.sixthc.part5.get.QueryDERGroupForecasts.QueryDERGroupForecastsPort;
import com.sixthc.part5.get.QueryDERGroupForecasts.ReplyType;

public class QueryDERGroupForecasts implements QueryDERGroupForecastsPort,
		ApplicationContextAware {

	ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;

	}

	@Override
	public DERGroupForecastQueriesResponseMessageType queryDERGroupForecasts(
			DERGroupForecastQueriesRequestMessageType queryDERGroupForecastsRequestMessage)
			throws QueryDERGroupForecastsFaultMessage {
		
		DERGroupForecastQueriesResponseMessageType msg = new DERGroupForecastQueriesResponseMessageType();
		
		// give them their own messageID back as correlation id
		String messageID = queryDERGroupForecastsRequestMessage.getHeader().getMessageID();

		HeaderType header = appContext.getBean(
				"get_queryDERGroupForecasts_header", HeaderType.class);
		msg.setHeader(header);
		
		header.setCorrelationID(messageID);
		
		
		ReplyType reply = appContext.getBean(
		"get_queryDERGroupForecasts_reply", ReplyType.class);
		
		ErrorType error =  appContext.getBean(
				"get_queryDERGroupForecasts_error", ErrorType.class);
		reply.getError().clear();
		reply.getError().add(error);
		
		msg.setReply(reply);
				
		return msg;
	}

}
