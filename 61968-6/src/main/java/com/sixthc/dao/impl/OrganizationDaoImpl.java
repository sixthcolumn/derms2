package com.sixthc.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sixthc.dao.OrganizationDao;
import com.sixthc.hbm.NameTypeAuthority;
import com.sixthc.hbm.Nametype;
import com.sixthc.hbm.Organization;
import com.sixthc.hbm.OrganizationNames;
import com.sixthc.util.CustomHibernateDaoSupport;

@Repository("organizationDao")
public class OrganizationDaoImpl extends CustomHibernateDaoSupport implements
		OrganizationDao {
	private static org.apache.log4j.Logger log = Logger
			.getLogger(OrganizationDaoImpl.class);

	@Override
	public void save(Organization Organization) {
		getHibernateTemplate().save(Organization);
	}
	
	public void saveName(OrganizationNames name) {
		getHibernateTemplate().save(name);
	}

	@Override
	public void update(Organization log) {
		getHibernateTemplate().update(log);
	}

	@Override
	public void delete(Organization log) {
		getHibernateTemplate().delete(log);
	}

	public void saveOrUpdate(Organization log) {
		getHibernateTemplate().saveOrUpdate(log);
	}
	
	public void saveNameTypeAuthority(NameTypeAuthority nta) {
		getHibernateTemplate().saveOrUpdate(nta);
	}
	
	public void saveNameType(Nametype nt) {
		getHibernateTemplate().saveOrUpdate(nt);
	}
}
