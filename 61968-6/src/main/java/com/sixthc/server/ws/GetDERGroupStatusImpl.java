package com.sixthc.server.ws;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import ch.iec.tc57._2011.schema.message.HeaderType;
import ch.iec.tc57._2011.schema.message.ReplyType;

import com.epri.dergroupstatuses.DERGroupStatus;
import com.epri.dergroupstatuses.DERGroupStatuses;
import com.epri.dergroupstatuses.EndDeviceGroup;
import com.epri.getdergroupstatuses.GetDERGroupStatusesFaultMessage;
import com.epri.getdergroupstatuses.GetDERGroupStatusesPort;
import com.epri.getdergroupstatusesmessage.DERGroupStatusesPayloadType;
import com.epri.getdergroupstatusesmessage.GetDERGroupStatusesRequestMessageType;
import com.epri.getdergroupstatusesmessage.GetDERGroupStatusesResponseMessageType;

public class GetDERGroupStatusImpl implements GetDERGroupStatusesPort,
		ApplicationContextAware {
	private static org.apache.log4j.Logger log = Logger
			.getLogger(GetDERGroupStatusImpl.class);
	ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;

	}

	@Override
	public GetDERGroupStatusesResponseMessageType getDERGroupStatuses(
			GetDERGroupStatusesRequestMessageType getDERGroupStatusesRequestMessage)
			throws GetDERGroupStatusesFaultMessage {
		
		// response message
		GetDERGroupStatusesResponseMessageType response = new GetDERGroupStatusesResponseMessageType();
		
		// set reply values
		ReplyType reply = new ReplyType();
		reply.setResult("OK");
		response.setReply(reply);
		
		// get all the status data from a bean (we only get one for now)
		DERGroupStatus status = appContext.getBean("CIMDERGroupStatus", DERGroupStatus.class);
		
		
		// add the status to the array of statuses
		DERGroupStatuses statuses = new DERGroupStatuses();
		statuses.getDERGroupStatuses().add(status);
		
		// add the statuses to the payload... sheesh!
		DERGroupStatusesPayloadType payload = new DERGroupStatusesPayloadType();
		payload.setDERGroupStatuses(statuses);

		// add our payload to the response
		response.setPayload(payload);

		// send them back their own header in our response
		HeaderType header = getDERGroupStatusesRequestMessage.getHeader();
		response.setHeader(header);

		return response;
	}

	//	
	//	@Override
	//	public GetDERGroupStatusesResponseMessageType getDERGroupStatuses(
	//			GetDERGroupStatusesRequestMessageType getDERGroupStatusesRequestMessage)
	//			throws GetDERGroupStatusesFaultMessage {
	//
	//
	//	//	DERGroups e = appContext.getBean("CIMDERGroupStatus", DERGroups.class);
	//
	//		GetDERGroupStatusesResponseMessageType response = new GetDERGroupStatusesResponseMessageType();
	//		ReplyType reply = new ReplyType();
	//		response.setReply(reply);
	//		DERGroupStatusesPayloadType payload = new DERGroupStatusesPayloadType();
	//		response.setPayload(payload);
	//		DERGroupStatuses statuses = new DERGroupStatuses();
	//		payload.setDERGroupStatuses(statuses);
	//		DERGroupStatus status = new DERGroupStatus();
	//		statuses.getDERGroupStatuses().add(status);
	//		
	//		
	//		HeaderType header = getDERGroupStatusesRequestMessage.getHeader();
	//		response.setHeader(header);
	//		
	//		status.setMRID("1234");
	//		status.setName("der1");
	//		status.setEndDeviceGroup(new EndDeviceGroup());
	//		EndDeviceGroup group = status.getEndDeviceGroup();
	//		
	//		Status gstatus = new Status();
	//		group.setStatus(gstatus);
	//		gstatus.setValue("14.2");
	//		
	//		GregorianCalendar c = new GregorianCalendar();
	//		c.setTimeInMillis(System.currentTimeMillis());
	//		XMLGregorianCalendar date2;
	//		try {
	//			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
	//			gstatus.setDateTime(date2);
	//		} catch (DatatypeConfigurationException ex) {
	//			// TODO Auto-generated catch block
	//			ex.printStackTrace();
	//		}		
	//
	//		ActivePower ap = new ActivePower();
	//		ap.setMultiplier("k");
	//		ap.setValue((float) 12.5);
	//		ap.setUnit("W");
	//		group.setCurrentActivePower(ap);
	//		
	//		ActivePower app = new ActivePower();
	//		app.setMultiplier("k");
	//		app.setValue((float) 10.5);
	//		app.setUnit("VA");
	//		group.setCurrentApparentPower(app);
	//
	//				
	//		ActivePower rp = new ActivePower();
	//		rp.setMultiplier("k");
	//		rp.setValue((float) 11.0);
	//		rp.setUnit("VAr");
	//		group.setCurrentReactivePower(rp);
	//		
	//		
	//		reply.setResult("OK");
	//
	//		return response;
	//	}
	//	
	//	private ActivePower setActivePower(double value) {
	//		ActivePower ap = new ActivePower();
	//		ap.setValue((float)value);
	//		ap.setMultiplier("k");
	//		ap.setUnit("W");		
	//		return ap;
	//	}
	//	
	//	private ReactivePower setReactivePower(double value) {
	//		ReactivePower ap = new ReactivePower();
	//		ap.setValue((float)value);
	//		ap.setMultiplier("k");
	//		ap.setUnit("VAr");		
	//		return ap;
	//	}
	//	
	//	private ApparentPower setApparentPower(double value) {
	//		ApparentPower ap = new ApparentPower();
	//		ap.setValue((float)value);
	//		ap.setMultiplier("k");
	//		ap.setUnit("VA");		
	//		return ap;
	//	}
	//
	//	//	@Override
	//	//	public void getDERGroupStatus(Holder<HeaderType> header,
	//	//			GetDERGroupStatusRequestType request,
	//	//			Holder<DERGroupStatusPayloadType> payload, Holder<ReplyType> reply)
	//	//			throws FaultMessage {
	//	//		log.debug("***** OPERATION : getDERGroupStatus");
	//	//		
	//	//		DERGroupStatus e =  appContext.getBean(
	//	//				"CIMDERGroupStatus",
	//	//				DERGroupStatus.class);
	//	//		
	//	//		payload.value.getDERGroupStatuses().getDERGroupStatuses().clear();
	//	//		payload.value.getDERGroupStatuses().getDERGroupStatuses().add(e);
	//	//		
	//	//		ReplyType r = appContext.getBean(("ReplyTypeBean"), ReplyType.class);
	//	//		reply.value = r;
	//	//		
	//	//	}

}
