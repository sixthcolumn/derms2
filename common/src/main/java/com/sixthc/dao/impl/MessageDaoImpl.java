package com.sixthc.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sixthc.dao.MessageDao;
import com.sixthc.model.Message;
import com.sixthc.model.Pkg;
import com.sixthc.model.PkgGroup;
import com.sixthc.model.Vendor;
import com.sixthc.util.CustomHibernateDaoSupport;

@Repository("MessageDao")
public class MessageDaoImpl extends CustomHibernateDaoSupport implements MessageDao {
	private static org.apache.log4j.Logger log = Logger
	.getLogger(MessageDaoImpl.class);
	@Override
	public void save(Message face) {
		getHibernateTemplate().save(face);
		// TODO : I know this way of setting default date is kludge. should
		// probably write an even handler or use jpa
	}

	@Override
	public void update(Message face) {
		getHibernateTemplate().update(face);
	}

	@Override
	public void delete(Message face) {
		getHibernateTemplate().delete(face);
	}

	@Override
	public Message findById(int id) {
		List<Message> list = getHibernateTemplate().find("from Message where id=?",
				id);
		return (Message) list.get(0);
	}

	public Message findByName(String name) {
		List<Message> list = getHibernateTemplate().find(
				"from Message where name = ? ", name);
		if (list.size() > 0)
			return (Message) list.get(0);
		return null;
	}

	public Message find(String name, PkgGroup pkgGroup) {
		List<Message> list = getHibernateTemplate().find(
				"from Message where name = ? and package_group_id = ?", name,
				new Integer(pkgGroup.getId()));
		if (list.size() > 0)
			return (Message) list.get(0);
		return null;
	}

}
