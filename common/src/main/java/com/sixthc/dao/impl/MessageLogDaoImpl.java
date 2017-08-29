package com.sixthc.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sixthc.dao.MessageDao;
import com.sixthc.dao.MessageLogDao;
import com.sixthc.dao.PkgDao;
import com.sixthc.dao.PkgGroupDao;
import com.sixthc.dao.Sequence;
import com.sixthc.model.Message;
import com.sixthc.model.MessageLog;
import com.sixthc.model.Pkg;
import com.sixthc.model.PkgGroup;
import com.sixthc.util.CustomHibernateDaoSupport;

@Repository("MessageLogDao")
public class MessageLogDaoImpl extends CustomHibernateDaoSupport implements
		MessageLogDao {
	private static org.apache.log4j.Logger log = Logger
			.getLogger(MessageLogDaoImpl.class);

	@Autowired
	private PkgGroupDao pkgGroupDao;
	
	@Autowired
	private PkgDao pkgDao;

	@Autowired
	private MessageDao messageDao;
	
	public boolean messageIDIsUnique(String messageID) {
		List<MessageLog> list = getHibernateTemplate().find(
				"from MessageLog where messageId=?", messageID);
		if (list.size() > 0)
			return false;
		return true;
	}
	
	public MessageLog findByCorrelation(String correlationID) {
		List<MessageLog> list = getHibernateTemplate().find(
				"from MessageLog where messageId=?", correlationID);
		if (list.size() > 0)
			return (MessageLog) list.get(0);
		return null;	
	}


	public void setMessage(MessageLog messageLog) {
		Pkg pkg = null;
		PkgGroup pkgGroup = null;
		Message message = null;
		
		if( messageLog.getPackageName() == null) {
			log.error("package name not set");
			return;
		} else {
			pkg = pkgDao.findByName(messageLog.getPackageName());
			if( pkg == null ) {
				log.error("findByName for package name (" + messageLog.getPackageName() + ") failed");
				return;
			}
		}

		if(messageLog.getPackageGroupName() == null ) {
			log.error("package group name not set");
		} else {
			pkgGroup = pkgGroupDao.find(messageLog.getPackageGroupName(),pkg);
			if( pkgGroup == null ) {
				log.error("findByName for package group name (" + messageLog.getPackageGroupName() + ") failed.");
				return;
			}
		}
		
		if( messageLog.getMessageName() == null) {
			log.error("message name not set");
			return;
		} else {
			message = messageDao.find(messageLog.getMessageName(),pkgGroup);
			if( message == null ) {
				log.error("findbyName for message (" + messageLog.getMessageName() + ") failed.");
				return;
			}
			messageLog.setMessage(message);
		}
	}

	@Override
	public void save(MessageLog log) {
		if (log.getCreateDate() == null)
			log.setCreateDate(new Timestamp(System.currentTimeMillis()));

		getHibernateTemplate().save(log);
		// TODO : I know this way of setting default date is kludge. should
		// probably write an event handler or use jpa
	}

	@Override
	public void update(MessageLog log) {
		getHibernateTemplate().update(log);
	}

	@Override
	public void delete(MessageLog log) {
		getHibernateTemplate().delete(log);
	}

	@Override
	public MessageLog findById(int id) {
		List<MessageLog> list = getHibernateTemplate().find(
				"from MessageLog where id=?", id);
		if (list.size() > 0)
			return (MessageLog) list.get(0);
		return null;
	}

	public long getMessageIdSequence() {
		final int id[] = new int[1];
		Sequence seq = new Sequence(getHibernateTemplate().getSessionFactory()
				.getCurrentSession(), "message_id");
		return seq.getNext();
	}

	public void saveOrUpdate(MessageLog log) {
		getHibernateTemplate().saveOrUpdate(log);
	}
	
	public MessageLog findByMessageID(String messageID) {
		List<MessageLog> list = getHibernateTemplate().find(
				"from MessageLog where messageID=?", messageID);
		if (list.size() > 0)
			return (MessageLog) list.get(0);
		return null;
	}


}
