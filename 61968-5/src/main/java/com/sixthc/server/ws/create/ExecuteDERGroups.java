package com.sixthc.server.ws.create;

import javax.xml.ws.Holder;

import com.sixthc.part5.create.ExecuteDERGroups.DERGroupsPayloadType;
import com.sixthc.part5.create.ExecuteDERGroups.DERGroupsPort;
import com.sixthc.part5.create.ExecuteDERGroups.FaultMessage;
import com.sixthc.part5.create.ExecuteDERGroups.HeaderType;
import com.sixthc.part5.create.ExecuteDERGroups.ReplyType;
import com.sixthc.part5.create.ExecuteDERGroups.RequestType;

public class ExecuteDERGroups implements DERGroupsPort {

	@Override
	public void createDERGroups(Holder<HeaderType> header, RequestType request,
			Holder<DERGroupsPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {
		// TODO Auto-generated method stub

	}

}
