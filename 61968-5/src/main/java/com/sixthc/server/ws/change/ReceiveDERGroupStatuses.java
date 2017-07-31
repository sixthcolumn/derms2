package com.sixthc.server.ws.change;

import javax.xml.ws.Holder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sixthc.part5.change.ReceiveDERGroupStatuses.DERGroupStatusesPayloadType;
import com.sixthc.part5.change.ReceiveDERGroupStatuses.DERGroupStatusesPort;
import com.sixthc.part5.change.ReceiveDERGroupStatuses.ErrorType;
import com.sixthc.part5.change.ReceiveDERGroupStatuses.FaultMessage;
import com.sixthc.part5.change.ReceiveDERGroupStatuses.HeaderType;
import com.sixthc.part5.change.ReceiveDERGroupStatuses.ReplyType;

public class ReceiveDERGroupStatuses implements DERGroupStatusesPort,
		ApplicationContextAware {

	ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;
	}

	@Override
	public void changedDERGroupStatuses(Holder<HeaderType> header,
			Holder<DERGroupStatusesPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {

		// give them their own messageID back as correlation id
		String messageID = header.value.getMessageID();
		
		header.value = appContext.getBean("change_receiveDERGroupStatuses_header",
				HeaderType.class);

		header.value.setCorrelationID(messageID);
		
		// default reply, also replaced
		ErrorType et = appContext.getBean("change_receiveDERGroupStatuses_error",
				ErrorType.class);
		reply.value = appContext.getBean("change_receiveDERGroupStatuses_reply",
				ReplyType.class);
		reply.value.getError().add(et);
		
		payload.value = null;

	}

}
