package com.sixthc.server.ws;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import ch.iec.tc57._2011.schema.message.HeaderType;
import ch.iec.tc57._2011.schema.message.ReplyType;

import com.epri.dergroupstatuses.DERGroupStatus;
import com.epri.dergroupstatuses.DERGroupStatuses;
import com.epri.getdergroupstatuses.GetDERGroupStatusesFaultMessage;
import com.epri.getdergroupstatuses.GetDERGroupStatusesPort;
import com.epri.getdergroupstatusesmessage.DERGroupStatusesPayloadType;
import com.epri.getdergroupstatusesmessage.GetDERGroupStatusesRequestMessageType;
import com.epri.getdergroupstatusesmessage.GetDERGroupStatusesResponseMessageType;

public class GetDERGroupStatusImpl implements GetDERGroupStatusesPort,
		ApplicationContextAware {
	private static org.apache.log4j.Logger log = Logger
			.getLogger(GetDERGroupStatusImpl.class);
	ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;

	}

	@Override
	public GetDERGroupStatusesResponseMessageType getDERGroupStatuses(
			GetDERGroupStatusesRequestMessageType getDERGroupStatusesRequestMessage)
			throws GetDERGroupStatusesFaultMessage {
		
		// response message
		GetDERGroupStatusesResponseMessageType response = new GetDERGroupStatusesResponseMessageType();
		
		// set reply values
		ReplyType reply = new ReplyType();
		reply.setResult("OK");
		response.setReply(reply);
		
		// get all the status data from a bean (we only get one for now)
		DERGroupStatus status = appContext.getBean("CIMDERGroupStatus", DERGroupStatus.class);
		
		
		// add the status to the array of statuses
		DERGroupStatuses statuses = new DERGroupStatuses();
		statuses.getDERGroupStatuses().add(status);
		
		// add the statuses to the payload... sheesh!
		DERGroupStatusesPayloadType payload = new DERGroupStatusesPayloadType();
		payload.setDERGroupStatuses(statuses);

		// add our payload to the response
		response.setPayload(payload);

		// send them back their own header in our response
		HeaderType header = getDERGroupStatusesRequestMessage.getHeader();
		response.setHeader(header);

		return response;
	}

}
