package com.sixthc.server.ws.change;

import javax.xml.ws.Holder;

import com.sixthc.part5.change.ReceiveDERGroupStatuses.DERGroupStatusesPayloadType;
import com.sixthc.part5.change.ReceiveDERGroupStatuses.DERGroupStatusesPort;
import com.sixthc.part5.change.ReceiveDERGroupStatuses.FaultMessage;
import com.sixthc.part5.change.ReceiveDERGroupStatuses.HeaderType;
import com.sixthc.part5.change.ReceiveDERGroupStatuses.ReplyType;

public class ReceiveDERGroupStatuses implements DERGroupStatusesPort {

	@Override
	public void changedDERGroupStatuses(Holder<HeaderType> header,
			Holder<DERGroupStatusesPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {
		// TODO Auto-generated method stub

	}

}
