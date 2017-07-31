package com.sixthc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sixthc.dao.VendorDao;
import com.sixthc.model.Vendor;
import com.sixthc.util.CustomHibernateDaoSupport;

@Repository("VendorDao")
public class VendorDaoImpl extends CustomHibernateDaoSupport implements VendorDao {

	@Override
	public void save(Vendor Vendor) {
		getHibernateTemplate().save(Vendor);
		// TODO : I know this way of setting default date is kludge. should
		// probably write an even handler or use jpa
	}

	@Override
	public void update(Vendor Vendor) {
		getHibernateTemplate().update(Vendor);
	}

	@Override
	public void delete(Vendor Vendor) {
		getHibernateTemplate().delete(Vendor);
	}

	@Override
	public Vendor findById(int id) {
		List<Vendor> list = getHibernateTemplate().find("from Vendor where id=?", id);
		if (list.size() > 0)
			return (Vendor) list.get(0);
		return null;
	}

	public Vendor findByName(String name) {
		List<Vendor> list = getHibernateTemplate().find("from Vendor where name = ?",
				name);
		if (list.size() > 0)
			return (Vendor) list.get(0);
		return null;
	}

}
