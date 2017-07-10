package com.sixthc.server.ws.change;

import javax.xml.ws.Holder;

import com.sixthc.part5.change.ExecuteDERGroupsOperationSet.DERGroupsOperationSetPort;
import com.sixthc.part5.change.ExecuteDERGroupsOperationSet.DERGroupsPayloadType;
import com.sixthc.part5.change.ExecuteDERGroupsOperationSet.FaultMessage;
import com.sixthc.part5.change.ExecuteDERGroupsOperationSet.HeaderType;
import com.sixthc.part5.change.ExecuteDERGroupsOperationSet.ReplyType;
import com.sixthc.part5.change.ExecuteDERGroupsOperationSet.RequestType;


public class ExecuteDERGroupsOperationSet implements DERGroupsOperationSetPort {

	@Override
	public void executeDERGroupsOperationSet(Holder<HeaderType> header,
			RequestType request, Holder<DERGroupsPayloadType> payload,
			Holder<ReplyType> reply) throws FaultMessage {
		// TODO Auto-generated method stub
		
	}

}
