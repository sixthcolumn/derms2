package com.sixthc.server.ws;

import org.apache.log4j.Logger;

import com.sixthc.cim.deleteMaintenanceOrders.HeaderType;
import com.sixthc.cim.deleteMaintenanceOrders.ReplyType;
import com.sixthc.cim.deleteMaintenanceOrders.RequestType;
import com.sixthc.cim.deleteMaintenanceOrders.cxf.FaultMessage;
import com.sixthc.cim.deleteMaintenanceOrders.cxf.MaintenanceOrdersPayloadType;
import com.sixthc.cim.deleteMaintenanceOrders.cxf.MaintenanceOrdersPort;
import com.sixthc.client.ExecuteMaintOrderChangeDeleteClient;

public class RequestExecuteMaintOrderChangeDeleteImpl implements MaintenanceOrdersPort {
	private static org.apache.log4j.Logger log = Logger
	.getLogger(RequestExecuteMaintOrderChangeDeleteImpl.class);
	
	private ExecuteMaintOrderChangeDeleteClient client;
	
	public ExecuteMaintOrderChangeDeleteClient getClient() {
		return client;
	}
	
	public void setClient(ExecuteMaintOrderChangeDeleteClient client) {
		this.client = client;
	}

	@Override
	public void changeMaintenanceOrders(javax.xml.ws.Holder<HeaderType> header,
			RequestType request,
			javax.xml.ws.Holder<MaintenanceOrdersPayloadType> payload,
			javax.xml.ws.Holder<ReplyType> reply) throws FaultMessage {
		log.debug("changeMaintenanceOrders called");
		
		client.setHeader(header.value);
		client.setPayload(payload.value);
		client.setRequest(request);
		client.change();
		
		payload.value = client.getPayload();
		
		reply.value = new ReplyType();
		reply.value.setResult("OK");
		
	}

	@Override
	public void deleteMaintenanceOrders(javax.xml.ws.Holder<HeaderType> header,
			RequestType request,
			javax.xml.ws.Holder<MaintenanceOrdersPayloadType> payload,
			javax.xml.ws.Holder<ReplyType> reply) throws FaultMessage {
		log.debug("deleteMaintenanceOrders called");
		
		client.setHeader(header.value);
		client.setPayload(payload.value);
		client.setRequest(request);
		client.delete();
		
		payload.value = client.getPayload();
		
		reply.value = new ReplyType();
		reply.value.setResult("OK");
		
	}



}
