package com.sixthc.server.ws.change;

import javax.xml.ws.Holder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sixthc.part5.change.ExecuteDERGroups.DERGroupsPayloadType;
import com.sixthc.part5.change.ExecuteDERGroups.DERGroupsPort;
import com.sixthc.part5.change.ExecuteDERGroups.FaultMessage;
import com.sixthc.part5.change.ExecuteDERGroups.HeaderType;
import com.sixthc.part5.change.ExecuteDERGroups.ReplyType;
import com.sixthc.part5.change.ExecuteDERGroups.RequestType;
import com.sixthc.part5.change.ExecuteDERGroups.EndDeviceGroup;
import com.sixthc.part5.change.ExecuteDERGroups.ErrorType;

public class ExecuteDERGroups implements DERGroupsPort, ApplicationContextAware {

	ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;
	}

	@Override
	public void changeDERGroups(Holder<HeaderType> header, RequestType request,
			Holder<DERGroupsPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {
		
		// give them their own messageID back as correlation id
		String messageID = header.value.getMessageID();

		// default header, will be replaced (probably) during out intercept handler final phase
		header.value = appContext.getBean("change_executeDERGroups_header",
				HeaderType.class);

		header.value.setCorrelationID(messageID);

		// default reply, also replaced
		ErrorType et = appContext.getBean("change_executeDERGroups_error",
				ErrorType.class);
		reply.value = appContext.getBean("change_executeDERGroups_reply",
				ReplyType.class);
		reply.value.getError().clear();
		reply.value.getError().add(et);

		payload.value = null;

	}

	@Override
	public void deleteDERGroups(Holder<HeaderType> header, RequestType request,
			Holder<DERGroupsPayloadType> payload, Holder<ReplyType> reply)
			throws FaultMessage {

		// default header, will be replaced (probably) during out intercept handler final phase
		header.value = appContext.getBean("change_executeDERGroups_header",
				HeaderType.class);

		// default reply, also replaced
		ErrorType et = appContext.getBean("change_executeDERGroups_error",
				ErrorType.class);
		reply.value = appContext.getBean("change_executeDERGroups_reply",
				ReplyType.class);

		reply.value.getError().add(et);

		// cxf requires a single (in this case empty) EndDevicegroup
		EndDeviceGroup group = appContext.getBean(
				"change_executeDERGroups_endDeviceGroup", EndDeviceGroup.class);
		payload.value.getDERGroups().getEndDeviceGroup().add(group);

	}

}
