package com.sixthc.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.sixthc.cim.createMaintenanceOrders.cxf.ExecuteMaintenanceOrders;
import com.sixthc.cim.createMaintenanceOrders.cxf.FaultMessage;
import com.sixthc.cim.createMaintenanceOrders.cxf.MaintenanceOrdersPayloadType;
import com.sixthc.cim.createMaintenanceOrders.cxf.MaintenanceOrdersPort;
import com.sixthc.cim.createMaintenanceOrders.HeaderType;
import com.sixthc.cim.createMaintenanceOrders.ReplyType;
import com.sixthc.cim.createMaintenanceOrders.RequestType;

@Component
public class ExecuteMaintOrderCreateClient extends RequestClient {
	private static org.apache.log4j.Logger log = Logger
			.getLogger(ExecuteMaintOrderCreateClient.class);

	private static final QName SERVICE_NAME = new QName(
			"http://iec.ch/TC57/2015/ExecuteMaintenanceOrders",
			"ExecuteMaintenanceOrders");

	URL wsdlURL = ExecuteMaintOrderCreateClient.class
			.getResource("/resources/wsdl/CimCreate/ExecuteMaintenanceOrders.wsdl");
	private Holder<HeaderType> header = new Holder<HeaderType>();
	private Holder<MaintenanceOrdersPayloadType> payload = new Holder<MaintenanceOrdersPayloadType>();
	private Holder<ReplyType> reply = new Holder<ReplyType>();
	private RequestType request = new RequestType();

	public ExecuteMaintOrderCreateClient() {
		super();
	}

	public ExecuteMaintOrderCreateClient(HeaderType header,
			MaintenanceOrdersPayloadType payload, RequestType request) {
		this.header.value = header;
		this.payload.value = payload;
		this.request = request;
	}

	public void create() throws FaultMessage {
		String address = header.value.getReplyAddress();
		log.info("Reply(MaintenanceOrdersPayloadType) client");

		log.debug("wsdlURL " + wsdlURL);
		log.debug("SERVICE_NAME " + SERVICE_NAME);
		ExecuteMaintenanceOrders ss = new ExecuteMaintenanceOrders(wsdlURL,
				SERVICE_NAME);

		MaintenanceOrdersPort port = ss.getMaintenanceOrdersPort();
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

		port.createMaintenanceOrders(header, request, payload, reply);
		log.debug("createMaintenanceOrders executed");

	}

	public HeaderType getHeader() {
		return header.value;
	}

	public void setHeader(HeaderType header) {
		this.header.value = header;
	}

	public MaintenanceOrdersPayloadType getPayload() {
		return payload.value;
	}

	public void setPayload(MaintenanceOrdersPayloadType payload) {
		this.payload.value = payload;
	}

	public void setRequest(RequestType requestType) {
		this.request = requestType;
	}
}
