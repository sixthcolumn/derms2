package com.sixthc.server.ws.create;

import javax.xml.ws.Holder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sixthc.part5.create.receiveEndDeviceEvents.EndDeviceEventsPayloadType;
import com.sixthc.part5.create.receiveEndDeviceEvents.EndDeviceEventsPort;
import com.sixthc.part5.create.receiveEndDeviceEvents.ErrorType;
import com.sixthc.part5.create.receiveEndDeviceEvents.FaultMessage;
import com.sixthc.part5.create.receiveEndDeviceEvents.HeaderType;
import com.sixthc.part5.create.receiveEndDeviceEvents.ReplyType;
import com.sixthc.util.XMLUtil;

public class ReceiveEndDeviceEvents implements EndDeviceEventsPort,
ApplicationContextAware  {


	ApplicationContext appContext;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;

	}

	@Override
	public void createdEndDeviceEvents(Holder<HeaderType> header,
			Holder<EndDeviceEventsPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {		// give them their own messageID back as correlation id
		String messageID = header.value.getMessageID();

		header.value = appContext.getBean(
				"create_receiveEndDeviceEvents_header", HeaderType.class);
		header.value.setTimestamp(XMLUtil.XMLGregorianNow());
		header.value.setCorrelationID(messageID);
		
		// default reply, also replaced
		ErrorType et = appContext.getBean(
				"create_receiveEndDeviceEvents_error", ErrorType.class);
		reply.value = appContext.getBean(
				"create_receiveEndDeviceEvents_reply", ReplyType.class);
		reply.value.getError().clear();
		reply.value.getError().add(et);

		payload.value = null;
		
	}
}
