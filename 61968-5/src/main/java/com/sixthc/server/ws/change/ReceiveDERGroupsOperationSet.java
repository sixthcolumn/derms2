package com.sixthc.server.ws.change;

import javax.xml.ws.Holder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sixthc.part5.change.ReceiveDERGroupsOperationSet.DERGroupsOperationSetPort;
import com.sixthc.part5.change.ReceiveDERGroupsOperationSet.DERGroupsPayloadType;
import com.sixthc.part5.change.ReceiveDERGroupsOperationSet.ErrorType;
import com.sixthc.part5.change.ReceiveDERGroupsOperationSet.FaultMessage;
import com.sixthc.part5.change.ReceiveDERGroupsOperationSet.HeaderType;
import com.sixthc.part5.change.ReceiveDERGroupsOperationSet.ReplyType;



public class ReceiveDERGroupsOperationSet implements DERGroupsOperationSetPort, ApplicationContextAware {

	ApplicationContext appContext;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;
	}

	@Override
	public void executedDERGroupsOperationSet(Holder<HeaderType> header,
			Holder<DERGroupsPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {

		// default header, will be replaced (probably) during out intercept handler final phase
		header.value = appContext.getBean("change_receiveDERGroupsOperationSet_header",
				HeaderType.class);
		
		// default reply, also replaced
		ErrorType et = appContext.getBean("change_receiveDERGroupsOperationSet_error", ErrorType.class);
		reply.value = appContext.getBean("change_receiveDERGroupsOperationSet_reply",
				ReplyType.class);
		reply.value.getError().add(et);
				
		payload.value = null;
		
	}


}
