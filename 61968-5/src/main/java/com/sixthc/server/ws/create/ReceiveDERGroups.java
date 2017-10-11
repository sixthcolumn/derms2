package com.sixthc.server.ws.create;

import javax.xml.ws.Holder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sixthc.part5.create.ReceiveDERGroups.ErrorType;
import com.sixthc.part5.create.ReceiveDERGroups.DERGroupsPayloadType;
import com.sixthc.part5.create.ReceiveDERGroups.DERGroupsPort;
import com.sixthc.part5.create.ReceiveDERGroups.FaultMessage;
import com.sixthc.part5.create.ReceiveDERGroups.HeaderType;
import com.sixthc.part5.create.ReceiveDERGroups.ReplyType;
import com.sixthc.util.XMLUtil;

public class ReceiveDERGroups implements DERGroupsPort, ApplicationContextAware {

	ApplicationContext appContext;

	@Override
	public void createdDERGroups(Holder<HeaderType> header,
			Holder<DERGroupsPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {

		// give them their own messageID back as correlation id
		String messageID = header.value.getMessageID();
		
		header.value = appContext.getBean("create_receiveDERGroups_header",
				HeaderType.class);
		
		header.value.setCorrelationID(messageID);
		header.value.setTimestamp(XMLUtil.XMLGregorianNow());

		// default reply, also replaced
		ErrorType et = appContext.getBean("create_receiveDERGroups_error",
				ErrorType.class);
		reply.value = appContext.getBean("create_receiveDERGroups_reply",
				ReplyType.class);
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
