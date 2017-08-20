package com.sixthc.server.ws.change;

import javax.xml.ws.Holder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sixthc.part5.change.ReceiveDERGroups.DERGroupsPayloadType;
import com.sixthc.part5.change.ReceiveDERGroups.DERGroupsPort;
import com.sixthc.part5.change.ReceiveDERGroups.FaultMessage;
import com.sixthc.part5.change.ReceiveDERGroups.HeaderType;
import com.sixthc.part5.change.ReceiveDERGroups.ReplyType;
import com.sixthc.part5.change.ReceiveDERGroups.ErrorType;

public class ReceiveDERGroups implements DERGroupsPort, ApplicationContextAware {

	ApplicationContext appContext;

	@Override
	public void changedDERGroups(Holder<HeaderType> header,
			Holder<DERGroupsPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {

		
		// give them their own messageID back as correlation id
		String messageID = header.value.getMessageID();

		// default header, will be replaced (probably) during out intercept handler final phase
		header.value = appContext.getBean(
				"change_receiveDERGroups_header", HeaderType.class);
		
		header.value.setCorrelationID(messageID);
		
		// default reply, also replaced
		ErrorType et = appContext.getBean(
				"change_receiveDERGroups_error", ErrorType.class);
		reply.value = appContext.getBean(
				"change_receiveDERGroups_reply", ReplyType.class);
		reply.value.getError().clear();
		reply.value.getError().add(et);

		payload.value = null;

	}

	@Override
	public void deletedDERGroups(Holder<HeaderType> header,
			Holder<DERGroupsPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {

		// default header, will be replaced (probably) during out intercept handler final phase
		header.value = appContext.getBean(
				"change_receiveDERGroups_header", HeaderType.class);

		// default reply, also replaced
		ErrorType et = appContext.getBean(
				"change_receiveDERGroups_error", ErrorType.class);
		reply.value = appContext.getBean(
				"change_receiveDERGroups_reply", ReplyType.class);
		reply.value.getError().clear();
		reply.value.getError().add(et);

		payload.value = null;

	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;

	}

}
