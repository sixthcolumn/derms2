package com.sixthc.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.sixthc.cim.createServiceOrders.HeaderType;
import com.sixthc.cim.createServiceOrders.ReplyType;
import com.sixthc.cim.createServiceOrders.RequestType;
import com.sixthc.cim.createServiceOrders.cxf.ExecuteServiceOrders;
import com.sixthc.cim.createServiceOrders.cxf.FaultMessage;
import com.sixthc.cim.createServiceOrders.cxf.ServiceOrdersPayloadType;
import com.sixthc.cim.createServiceOrders.cxf.ServiceOrdersPort;

@Component
public class ExecuteServiceOrderCreateClient extends RequestClient {
	private static org.apache.log4j.Logger log = Logger
			.getLogger(ExecuteServiceOrderCreateClient.class);

	private static final QName SERVICE_NAME = new QName(
			"http://iec.ch/TC57/2015/ExecuteServiceOrders",
			"ExecuteServiceOrders");

	URL wsdlURL = ExecuteServiceOrderCreateClient.class
			.getResource("/resources/wsdl/create/ExecuteServiceOrders.wsdl");
	private Holder<HeaderType> header = new Holder<HeaderType>();
	private Holder<ServiceOrdersPayloadType> payload = new Holder<ServiceOrdersPayloadType>();
	private Holder<ReplyType> reply = new Holder<ReplyType>();
	private RequestType request = new RequestType();

	public ExecuteServiceOrderCreateClient() {
		super();
	}

	public ExecuteServiceOrderCreateClient(HeaderType header,
			ServiceOrdersPayloadType payload, RequestType request) {
		this.header.value = header;
		this.payload.value = payload;
		this.request = request;
	}

	public void create() throws FaultMessage {
		String address = header.value.getReplyAddress();
		log.info("Reply(ServiceOrdersPayloadType) client");

		log.debug("wsdlURL " + wsdlURL);
		log.debug("SERVICE_NAME " + SERVICE_NAME);
		ExecuteServiceOrders ss = new ExecuteServiceOrders(wsdlURL,
				SERVICE_NAME);

		ServiceOrdersPort port = ss.getServiceOrdersPort();
		BindingProvider provider = (BindingProvider) port;
		log.debug("end point address " + address);
		provider.getRequestContext().put(
				BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);

		// Register all the logging interceptors
		Client cxfClient = ClientProxy.getClient(port);

		cxfClient.getInInterceptors().add(loggingInInterceptor);
		cxfClient.getInFaultInterceptors().add(loggingInFaultInterceptor);
		cxfClient.getOutInterceptors().add(loggingOutInterceptor);
		cxfClient.getOutFaultInterceptors().add(loggingOutFaultInterceptor);

		// execute client request
		reply.value = new ReplyType();
		reply.value.setResult("OK");

		port.createServiceOrders(header, request, payload, reply);
		log.debug("createServiceOrders executed");

	}

	public HeaderType getHeader() {
		return header.value;
	}

	public void setHeader(HeaderType header) {
		this.header.value = header;
	}

	public ServiceOrdersPayloadType getPayload() {
		return payload.value;
	}

	public void setPayload(ServiceOrdersPayloadType payload) {
		this.payload.value = payload;
	}

	public void setRequest(RequestType requestType) {
		this.request = requestType;
	}
}
