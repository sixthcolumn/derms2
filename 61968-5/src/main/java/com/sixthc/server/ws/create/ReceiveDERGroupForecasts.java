package com.sixthc.server.ws.create;

import javax.xml.ws.Holder;

import com.sixthc.part5.create.ReceiveDERGroupForecasts.DERGroupForecastsPayloadType;
import com.sixthc.part5.create.ReceiveDERGroupForecasts.DERGroupForecastsPort;
import com.sixthc.part5.create.ReceiveDERGroupForecasts.FaultMessage;
import com.sixthc.part5.create.ReceiveDERGroupForecasts.HeaderType;
import com.sixthc.part5.create.ReceiveDERGroupForecasts.ReplyType;

public class ReceiveDERGroupForecasts implements DERGroupForecastsPort {

	@Override
	public void createdDERGroupForecasts(Holder<HeaderType> header,
			Holder<DERGroupForecastsPayloadType> payload,
			Holder<ReplyType> reply) throws FaultMessage {
		// TODO Auto-generated method stub

	}

}
