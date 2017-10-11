package com.sixthc.server.ws.create;

import javax.xml.ws.Holder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sixthc.part5.create.executeDERGroupDispatches.DERCurveData;
import com.sixthc.part5.create.executeDERGroupDispatches.DERGroupDispatch;
import com.sixthc.part5.create.executeDERGroupDispatches.DERGroupDispatchesPayloadType;
import com.sixthc.part5.create.executeDERGroupDispatches.DERGroupDispatchesPort;
import com.sixthc.part5.create.executeDERGroupDispatches.DispatchSchedule;
import com.sixthc.part5.create.executeDERGroupDispatches.ErrorType;
import com.sixthc.part5.create.executeDERGroupDispatches.FaultMessage;
import com.sixthc.part5.create.executeDERGroupDispatches.HeaderType;
import com.sixthc.part5.create.executeDERGroupDispatches.ReplyType;
import com.sixthc.part5.create.executeDERGroupDispatches.RequestType;
import com.sixthc.util.XMLUtil;

public class ExecuteDERGroupDispatches implements DERGroupDispatchesPort,
		ApplicationContextAware {

	ApplicationContext appContext;

	@Override
	public void createDERGroupDispatches(Holder<HeaderType> header,
			RequestType request, Holder<DERGroupDispatchesPayloadType> payload,
			Holder<ReplyType> reply) throws FaultMessage {

		// give them their own messageID back as correlation id
		String messageID = header.value.getMessageID();

		header.value = appContext.getBean(
				"create_executeDERGroupDispatches_header", HeaderType.class);
		
		header.value.setTimestamp(XMLUtil.XMLGregorianNow());
		header.value.setCorrelationID(messageID);
		
		// default reply, also replaced
		ErrorType et = appContext.getBean(
				"create_executeDERGroupDispatches_error", ErrorType.class);
		reply.value = appContext.getBean(
				"create_executeDERGroupDispatches_reply", ReplyType.class);
		reply.value.getError().clear();
		reply.value.getError().add(et);

		payload.value = null;

		//		DERGroupDispatch dispatch = appContext.getBean(
		//				"create_executeDERGroupDispatch", DERGroupDispatch.class);
		//		
		//
		//
		//		//payload.value = new DERGroupDispatchesPayloadType();
		//		payload.value.getDERGroupDispatches().getDERGroupDispatch().clear();
		//		payload.value.getDERGroupDispatches().getDERGroupDispatch()
		//				.add(dispatch);
		//
		//		DispatchSchedule ds = appContext.getBean("dispatchSchedule",
		//				DispatchSchedule.class);
		//		dispatch.getEndDeviceGroup().getDERMonitorableParameter()
		//		.getDispatchSchedule().add(ds);
		//
		//		DERCurveData dcd = appContext.getBean("DERCurveData",
		//				DERCurveData.class);
		//
		//		ds.getDERCurveData().add(dcd);

	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;

	}

}
