package com.sixthc.server.ws.create;

import javax.xml.ws.Holder;

import com.sixthc.part5.create.ReceiveDERGroups.DERGroupsPayloadType;
import com.sixthc.part5.create.ReceiveDERGroups.DERGroupsPort;
import com.sixthc.part5.create.ReceiveDERGroups.FaultMessage;
import com.sixthc.part5.create.ReceiveDERGroups.HeaderType;
import com.sixthc.part5.create.ReceiveDERGroups.ReplyType;

public class ReceiveDERGroups implements DERGroupsPort {

	@Override
	public void createdDERGroups(Holder<HeaderType> header,
			Holder<DERGroupsPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {
		// TODO Auto-generated method stub

	}

}
