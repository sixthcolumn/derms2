package com.sixthc.server.ws.change;

import javax.xml.ws.Holder;

import com.sixthc.part5.change.ReceiveDERGroups.DERGroupsPayloadType;
import com.sixthc.part5.change.ReceiveDERGroups.DERGroupsPort;
import com.sixthc.part5.change.ReceiveDERGroups.FaultMessage;
import com.sixthc.part5.change.ReceiveDERGroups.HeaderType;
import com.sixthc.part5.change.ReceiveDERGroups.ReplyType;

public class ReceiveDERGroups implements DERGroupsPort {

	@Override
	public void changedDERGroups(Holder<HeaderType> header,
			Holder<DERGroupsPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletedDERGroups(Holder<HeaderType> header,
			Holder<DERGroupsPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {
		// TODO Auto-generated method stub

	}

}
