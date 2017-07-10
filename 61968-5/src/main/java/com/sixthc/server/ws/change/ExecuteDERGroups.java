package com.sixthc.server.ws.change;

import javax.xml.ws.Holder;

import com.sixthc.part5.change.ExecuteDERGroups.DERGroupsPayloadType;
import com.sixthc.part5.change.ExecuteDERGroups.DERGroupsPort;
import com.sixthc.part5.change.ExecuteDERGroups.FaultMessage;
import com.sixthc.part5.change.ExecuteDERGroups.HeaderType;
import com.sixthc.part5.change.ExecuteDERGroups.ReplyType;
import com.sixthc.part5.change.ExecuteDERGroups.RequestType;

public class ExecuteDERGroups implements DERGroupsPort {

	@Override
	public void changeDERGroups(Holder<HeaderType> header, RequestType request,
			Holder<DERGroupsPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDERGroups(Holder<HeaderType> header, RequestType request,
			Holder<DERGroupsPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {
		// TODO Auto-generated method stub
		
	}



}
