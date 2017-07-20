package com.sixthc.server.ws.create;

import javax.xml.ws.Holder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sixthc.part5.create.ExecuteDERGroups.DERGroupsPayloadType;
import com.sixthc.part5.create.ExecuteDERGroups.DERGroupsPort;
import com.sixthc.part5.create.ExecuteDERGroups.ErrorType;
import com.sixthc.part5.create.ExecuteDERGroups.FaultMessage;
import com.sixthc.part5.create.ExecuteDERGroups.HeaderType;
import com.sixthc.part5.create.ExecuteDERGroups.ReplyType;
import com.sixthc.part5.create.ExecuteDERGroups.RequestType;

public class ExecuteDERGroups implements DERGroupsPort, ApplicationContextAware {

	ApplicationContext appContext;
	
	@Override
	public void createDERGroups(Holder<HeaderType> header, RequestType request,
			Holder<DERGroupsPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {
		
		// default header, will be replaced (probably) during out intercept handler final phase
		header.value = appContext.getBean("create_executeDERGroups_header",
				HeaderType.class);

		// default reply, also replaced
		ErrorType et = appContext.getBean("create_executeDERGroups_error", ErrorType.class);
		reply.value = appContext.getBean("create_executeDERGroups_reply",
				ReplyType.class);
		reply.value.getError().add(et);
		
		payload.value = null;

//		// cxf requires a single (in this case empty) EndDevicegroup
//		EndDeviceGroup group = appContext.getBean(
//				"create_executeDERGroups_endDeviceGroup", EndDeviceGroup.class);
//		payload.value.getDERGroups().getEndDeviceGroup().clear();
//		payload.value.getDERGroups().getEndDeviceGroup().add(group);


	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;
		
	}

}
