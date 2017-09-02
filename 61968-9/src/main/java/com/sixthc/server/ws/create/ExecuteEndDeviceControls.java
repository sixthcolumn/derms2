package com.sixthc.server.ws.create;

import javax.xml.ws.Holder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sixthc.part5.create.executeEndDeviceControls.EndDeviceControlsPayloadType;
import com.sixthc.part5.create.executeEndDeviceControls.EndDeviceControlsPort;
import com.sixthc.part5.create.executeEndDeviceControls.ErrorType;
import com.sixthc.part5.create.executeEndDeviceControls.FaultMessage;
import com.sixthc.part5.create.executeEndDeviceControls.HeaderType;
import com.sixthc.part5.create.executeEndDeviceControls.ReplyType;
import com.sixthc.part5.create.executeEndDeviceControls.RequestType;
import com.sixthc.util.XMLUtil;

public class ExecuteEndDeviceControls implements EndDeviceControlsPort,
ApplicationContextAware {

	ApplicationContext appContext;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;

	}

	@Override
	public void createEndDeviceControls(Holder<HeaderType> header,
			RequestType request, Holder<EndDeviceControlsPayloadType> payload,
			Holder<ReplyType> reply) throws FaultMessage {

		
		// give them their own messageID back as correlation id
		String messageID = header.value.getMessageID();

		header.value = appContext.getBean(
				"create_executeEndDeviceControls_header", HeaderType.class);
		header.value.setTimestamp(XMLUtil.XMLGregorianNow());
		header.value.setCorrelationID(messageID);
		
		// default reply, also replaced
		ErrorType et = appContext.getBean(
				"create_executeEndDeviceControls_error", ErrorType.class);
		reply.value = appContext.getBean(
				"create_executeEndDeviceControls_reply", ReplyType.class);
		reply.value.getError().clear();
		reply.value.getError().add(et);

		payload.value = null;
		
	}

}
