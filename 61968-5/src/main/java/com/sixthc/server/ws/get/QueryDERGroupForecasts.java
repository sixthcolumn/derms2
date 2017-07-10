package com.sixthc.server.ws.get;

import com.sixthc.part5.get.QueryDERGroupForecasts.DERGroupForecastQueriesRequestMessageType;
import com.sixthc.part5.get.QueryDERGroupForecasts.DERGroupForecastQueriesResponseMessageType;
import com.sixthc.part5.get.QueryDERGroupForecasts.QueryDERGroupForecastsFaultMessage;
import com.sixthc.part5.get.QueryDERGroupForecasts.QueryDERGroupForecastsPort;

public class QueryDERGroupForecasts implements QueryDERGroupForecastsPort {

	@Override
	public DERGroupForecastQueriesResponseMessageType queryDERGroupForecasts(
			DERGroupForecastQueriesRequestMessageType queryDERGroupForecastsRequestMessage)
			throws QueryDERGroupForecastsFaultMessage {
		// TODO Auto-generated method stub
		return null;
	}

}
