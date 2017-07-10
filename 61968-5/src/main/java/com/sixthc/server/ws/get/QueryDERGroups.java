package com.sixthc.server.ws.get;

import com.sixthc.part5.get.QueryDERGroups.DERGroupQueriesRequestMessageType;
import com.sixthc.part5.get.QueryDERGroups.DERGroupQueriesResponseMessageType;
import com.sixthc.part5.get.QueryDERGroups.QueryDERGroupsFaultMessage;
import com.sixthc.part5.get.QueryDERGroups.QueryDERGroupsPort;

public class QueryDERGroups implements QueryDERGroupsPort {

	@Override
	public DERGroupQueriesResponseMessageType queryDERGroups(
			DERGroupQueriesRequestMessageType queryDERGroupsRequestMessage)
			throws QueryDERGroupsFaultMessage {
		// TODO Auto-generated method stub
		return null;
	}

}
