package com.sixthc.server.ws.create;

import javax.xml.ws.Holder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sixthc.part5.create.ReceiveDERGroupForecasts.DERGroupForecastsPayloadType;
import com.sixthc.part5.create.ReceiveDERGroupForecasts.DERGroupForecastsPort;
import com.sixthc.part5.create.ReceiveDERGroupForecasts.ErrorType;
import com.sixthc.part5.create.ReceiveDERGroupForecasts.FaultMessage;
import com.sixthc.part5.create.ReceiveDERGroupForecasts.HeaderType;
import com.sixthc.part5.create.ReceiveDERGroupForecasts.ReplyType;
import com.sixthc.util.XMLUtil;

public class ReceiveDERGroupForecasts implements DERGroupForecastsPort,
		ApplicationContextAware {

	ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;

	}

	@Override
	public void createdDERGroupForecasts(Holder<HeaderType> header,
			Holder<DERGroupForecastsPayloadType> payload,
			Holder<ReplyType> reply) throws FaultMessage {

		// give them their own messageID back as correlation id
		String messageID = header.value.getMessageID();

		header.value = appContext.getBean(
				"create_receiveDERGroupForecasts_header", HeaderType.class);
		header.value.setCorrelationID(messageID);
		header.value.setTimestamp(XMLUtil.XMLGregorianNow());

		// default reply, also replaced
		ErrorType et = appContext.getBean(
				"create_receiveDERGroupForecasts_error", ErrorType.class);
		reply.value = appContext.getBean(
				"create_receiveDERGroupForecasts_reply", ReplyType.class);
		reply.value.getError().clear();
		reply.value.getError().add(et);

		payload.value = null;

	}

}
