package com.sixthc.server.ws;

import javax.xml.ws.Holder;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import ch.iec.tc57._2011.schema.message.HeaderType;
import ch.iec.tc57._2011.schema.message.ReplyType;
import ch.iec.tc57._2011.schema.message.RequestType;

import com.epri.dergroupdispatches.DERGroupDispatch;
import com.epri.dergroupdispatchesmessage.DERGroupDispatchesPayloadType;
import com.epri.executedergroupdispatches.DERGroupDispatchesPort;

public class ChangeDERGroupDispatchImpl implements DERGroupDispatchesPort,
		ApplicationContextAware {



	private static org.apache.log4j.Logger log = Logger
			.getLogger(ChangeDERGroupDispatchImpl.class);

	ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;
	}


	@Override
	public void createDERGroupDispatches(Holder<HeaderType> header,
			RequestType request, Holder<DERGroupDispatchesPayloadType> payload,
			Holder<ReplyType> reply)
			throws com.epri.executedergroupdispatches.FaultMessage {
				
		DERGroupDispatch dispatch = appContext.getBean("CIMDERGroupDispatch",DERGroupDispatch.class);
		
		payload.value.getDERGroupDispatches().getDERGroupDispatch().clear();
		payload.value.getDERGroupDispatches().getDERGroupDispatch().add(dispatch);
		
		ReplyType r = appContext.getBean(("ReplyTypeBean"), ReplyType.class);
		reply.value = r;		
	}

}
