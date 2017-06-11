package com.sixthc.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sixthc.dao.MaintOrderDao;
import com.sixthc.hbm.Maintorder;
import com.sixthc.util.CustomHibernateDaoSupport;

@Repository("MaintOrderDao")
@Transactional
public class MaintOrderDaoImpl extends CustomHibernateDaoSupport implements
		MaintOrderDao {
	private static org.apache.log4j.Logger log = Logger
			.getLogger(MaintOrderDaoImpl.class);

	@Override
	public void save(Maintorder MaintOrder) {
		if (MaintOrder.getCreatedAt() == null)
			MaintOrder.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		getHibernateTemplate().save(MaintOrder);

	}

	@Override
	public void update(Maintorder log) {
		getHibernateTemplate().update(log);
	}

	@Override
	public void delete(Maintorder log) {
		getHibernateTemplate().delete(log);
	}

	public void saveOrUpdate(Maintorder log) {
		getHibernateTemplate().saveOrUpdate(log);
	}
	
	public Maintorder find(String mrid) {
		@SuppressWarnings("unchecked")
		List<Maintorder> list = getHibernateTemplate().find(
				"from Maintorder where mrid=?", mrid);
		if (list.size() > 0)
			return (Maintorder) list.get(0);
		return null;
	}
	
	public List<Maintorder> findAll() {
		List<Maintorder> list = getHibernateTemplate().find(
				"from Maintorder");
		return list;
	}
}
