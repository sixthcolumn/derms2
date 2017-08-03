package com.sixthc.interceptor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sixthc.dao.MessageDao;
import com.sixthc.model.Message;
import com.sixthc.util.DOMParser;

public class ReplaceMessageInterceptor extends MessageChangeInterceptor {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(ReplaceMessageInterceptor.class);
	
	private String messageName;
	
	@Autowired
	private MessageDao messageDao;

	@Override
	protected Logger getLogger() {
		return log;
	}

	@Override
	protected String changeOutboundMessage(String currentEnvelope) {
		log.debug("executing changeOutboundMessage Interceptor");
		// currentEnvelope = currentEnvelope.replaceAll("#correlation_id#", "1234-ab994");
		
		Message msg = messageDao.findByName(messageName);
		if( msg.getMsgReply() != null && msg.getMsgReply().getMessageText() != null ) {
			String newMsg = msg.getMsgReply().getMessageText();
			
			DOMParser dp = new DOMParser(currentEnvelope, newMsg);
			if( dp.isValid() ) {
				try {
					newMsg = dp.getSOAPModifiedText();					
				} catch (Exception e) {
					log.error(e);;
				}

			}
			
			return newMsg;
		}
		return currentEnvelope;
	}

	@Override
	protected String changeInboundMessage(String currentEnvelope) {
		log.debug("executing changeInboundMessage Interceptor");
		return currentEnvelope;
	}

	public String getMessageName() {
		return messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}
	
	
}
