package com.sixthc.interceptor;

import org.apache.log4j.Logger;

public class ReplaceMessageInterceptor extends MessageChangeInterceptor {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(ReplaceMessageInterceptor.class);

	@Override
	protected Logger getLogger() {
		return log;
	}

	@Override
	protected String changeOutboundMessage(String currentEnvelope) {
		log.debug("executing changeOutboundMessage Interceptor");
		currentEnvelope = currentEnvelope.replaceAll("#correlation_id#", "1234-ab994");
		
		return currentEnvelope;
	}

	@Override
	protected String changeInboundMessage(String currentEnvelope) {
		log.debug("executing changeInboundMessage Interceptor");
		return currentEnvelope;
	}

}
