package com.sixthc.server.ws;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import ch.iec.tc57._2011.schema.message.HeaderType;
import ch.iec.tc57._2011.schema.message.ReplyType;
import ch.iec.tc57._2011.schema.message.RequestType;

import com.epri._2013.dergroupforecasts.DERGroupForecast;
import com.epri._2016.dergroupforecastsmessage.DERGroupForecastsPayloadType;
import com.epri._2016.executedergroupforecasts.DERGroupForecastsPort;
import com.epri._2016.executedergroupforecasts.FaultMessage;

public class ChangeDERGroupForecastsImpl implements DERGroupForecastsPort,
		ApplicationContextAware {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(ChangeDERGroupForecastsImpl.class);

	ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		appContext = arg0;
	}

	@Override
	public void createDERGroupForecasts(Holder<HeaderType> header,
			RequestType request, Holder<DERGroupForecastsPayloadType> payload,
			Holder<ReplyType> reply) throws FaultMessage {

		log.debug("***** OPERATION : createDERGroupForecast");

		DERGroupForecast forecast = appContext.getBean("CIMDERGroupForecast",
				DERGroupForecast.class);
		

		// TODO : Create factory in spring so I can move this to databeans.xml
		GregorianCalendar gcal = (GregorianCalendar) GregorianCalendar
				.getInstance();
		XMLGregorianCalendar xgcal;
		

		try {
			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
			forecast.setPredictionCreationDate(xgcal);
			forecast.setPredictionStartDate(xgcal);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		payload.value.getDERGroupForecasts().getDERGroupForecast().clear();
		payload.value.getDERGroupForecasts().getDERGroupForecast()
				.add(forecast);

		ReplyType r = appContext.getBean(("ReplyTypeBean"), ReplyType.class);
		reply.value = r;

	}

	//	@Override
	//	public void cancelDERGroupForecast(Holder<HeaderType> header,
	//			RequestType request, Holder<DERGroupForecastPayloadType> payload,
	//			Holder<ReplyType> reply)
	//			throws ch.iec.tc57._2011.requestdergroupforecast.FaultMessage {
	//		log.error("***** OPERATION : cancelDERGroupForecast");
	//		throw new ch.iec.tc57._2011.requestdergroupforecast.FaultMessage("Operation not supported");
	//	}
	//
	//
	//	@Override
	//	public void createDERGroupForecast(Holder<HeaderType> header,
	//			RequestType request, Holder<DERGroupForecastPayloadType> payload,
	//			Holder<ReplyType> reply)
	//			throws ch.iec.tc57._2011.requestdergroupforecast.FaultMessage {
	//
	//		log.debug("***** OPERATION : createDERGroupForecast");
	//		
	//		DERGroupForecast d = appContext.getBean(
	//				"CIMDERGroupForecast",
	//				DERGroupForecast.class);
	//		
	//		// TODO : Create factory in spring so I can move this to databeans.xml
	//		GregorianCalendar gcal = (GregorianCalendar) GregorianCalendar
	//				.getInstance();
	//		XMLGregorianCalendar xgcal;
	//		
	//		try {
	//			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
	//			d.setForecastBegin(xgcal);
	//			d.setForecastEnd(xgcal);
	//		} catch (DatatypeConfigurationException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//
	//		payload.value.getDERGroupForecasts().getDERGroupForecast().clear();
	//		payload.value.getDERGroupForecasts().getDERGroupForecast().add(d);	
	//		
	//		ReplyType r = appContext.getBean(("ReplyTypeBean"), ReplyType.class);
	//		reply.value = r;
	//	}
	//
	//
	//
	//	@Override
	//	public void closeDERGroupForecast(Holder<HeaderType> header,
	//			RequestType request, Holder<DERGroupForecastPayloadType> payload,
	//			Holder<ReplyType> reply)
	//			throws ch.iec.tc57._2011.requestdergroupforecast.FaultMessage {
	//		
	//		log.error("***** OPERATION : closeDERGroupForecast");
	//
	//		throw new ch.iec.tc57._2011.requestdergroupforecast.FaultMessage("Operation not supported");
	//		
	//	}
	//
	//	@Override
	//	public void changeDERGroupForecast(Holder<HeaderType> header,
	//			RequestType request, Holder<DERGroupForecastPayloadType> payload,
	//			Holder<ReplyType> reply)
	//			throws ch.iec.tc57._2011.requestdergroupforecast.FaultMessage {
	//		log.error("***** OPERATION : changeDERGroupForecast");
	//
	//		throw new ch.iec.tc57._2011.requestdergroupforecast.FaultMessage("Operation not supported");
	//	}
	//
	//	@Override
	//	public void deleteDERGroupForecast(Holder<HeaderType> header,
	//			RequestType request, Holder<DERGroupForecastPayloadType> payload,
	//			Holder<ReplyType> reply)
	//			throws ch.iec.tc57._2011.requestdergroupforecast.FaultMessage {
	//		log.error("***** OPERATION : deleteDERGroupForecast");
	//
	//		throw new ch.iec.tc57._2011.requestdergroupforecast.FaultMessage("Operation not supported");
	//	}

}
