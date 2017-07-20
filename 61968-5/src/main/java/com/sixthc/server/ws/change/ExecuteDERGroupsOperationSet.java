package com.sixthc.server.ws.change;

import java.math.BigInteger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.Holder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sixthc.part5.change.ExecuteDERGroupsOperationSet.DERGroupsOperationSetPort;
import com.sixthc.part5.change.ExecuteDERGroupsOperationSet.DERGroupsPayloadType;
import com.sixthc.part5.change.ExecuteDERGroupsOperationSet.ErrorType;
import com.sixthc.part5.change.ExecuteDERGroupsOperationSet.FaultMessage;
import com.sixthc.part5.change.ExecuteDERGroupsOperationSet.HeaderType;
import com.sixthc.part5.change.ExecuteDERGroupsOperationSet.OperationSet;
import com.sixthc.part5.change.ExecuteDERGroupsOperationSet.OperationType;
import com.sixthc.part5.change.ExecuteDERGroupsOperationSet.ReplyType;
import com.sixthc.part5.change.ExecuteDERGroupsOperationSet.RequestType;


public class ExecuteDERGroupsOperationSet implements DERGroupsOperationSetPort, ApplicationContextAware {

	ApplicationContext appContext;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;
	}

	@Override
	public void executeDERGroupsOperationSet(Holder<HeaderType> header,
			RequestType request, Holder<DERGroupsPayloadType> payload,
			Holder<ReplyType> reply) throws FaultMessage {


		// default header, will be replaced (probably) during out intercept handler final phase
		header.value = appContext.getBean("change_executeDERGroupsOperationSet_header",
				HeaderType.class);
		
		// default reply, also replaced
		ErrorType et = appContext.getBean("change_executeDERGroupsOperationSet_error", ErrorType.class);
		reply.value = appContext.getBean("change_executeDERGroupsOperationSet_reply",
				ReplyType.class);
		reply.value.getError().add(et);
				
		payload.value = new DERGroupsPayloadType();

	}

}
