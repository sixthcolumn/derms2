package com.sixthc.server.ws.create;

import javax.xml.ws.Holder;

import com.sixthc.part5.create.executeDERGroupDispatches.DERGroupDispatchesPayloadType;
import com.sixthc.part5.create.executeDERGroupDispatches.DERGroupDispatchesPort;
import com.sixthc.part5.create.executeDERGroupDispatches.FaultMessage;
import com.sixthc.part5.create.executeDERGroupDispatches.HeaderType;
import com.sixthc.part5.create.executeDERGroupDispatches.ReplyType;
import com.sixthc.part5.create.executeDERGroupDispatches.RequestType;

public class ExecuteDERGroupDispatches implements DERGroupDispatchesPort {

	@Override
	public void createDERGroupDispatches(Holder<HeaderType> header,
			RequestType request, Holder<DERGroupDispatchesPayloadType> payload,
			Holder<ReplyType> reply) throws FaultMessage {
		// TODO Auto-generated method stub

	}

}
