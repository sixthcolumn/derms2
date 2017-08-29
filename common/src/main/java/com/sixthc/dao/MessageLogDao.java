package com.sixthc.dao;

import com.sixthc.model.MessageLog;

public interface MessageLogDao {

	public void save(MessageLog log);
	public void update(MessageLog log);
	public void delete(MessageLog log);
	public MessageLog findById(int id);
	public long getMessageIdSequence();
	public void setMessage(MessageLog log);
	public void saveOrUpdate(MessageLog log);
	public boolean messageIDIsUnique(String messageID);
	public MessageLog findByMessageID(String messageID);
	public MessageLog findByCorrelation(String correlationID);
}
