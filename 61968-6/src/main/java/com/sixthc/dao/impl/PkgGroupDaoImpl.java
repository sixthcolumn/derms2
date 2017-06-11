package com.sixthc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sixthc.dao.PkgGroupDao;
import com.sixthc.model.Pkg;
import com.sixthc.model.PkgGroup;
import com.sixthc.util.CustomHibernateDaoSupport;

@Repository("PkgGroupDao")
public class PkgGroupDaoImpl extends CustomHibernateDaoSupport implements PkgGroupDao {

	@Override
	public void save(PkgGroup PkgGroup) {
		getHibernateTemplate().save(PkgGroup);
		// TODO : I know this way of setting default date is kludge. should
		// probably write an even handler or use jpa
	}

	@Override
	public void update(PkgGroup PkgGroup) {
		getHibernateTemplate().update(PkgGroup);
	}

	@Override
	public void delete(PkgGroup PkgGroup) {
		getHibernateTemplate().delete(PkgGroup);
	}

	@Override
	public PkgGroup findById(int id) {
		List<PkgGroup> list = getHibernateTemplate().find("from PkgGroup where id=?", id);
		if (list.size() > 0)
			return (PkgGroup) list.get(0);
		return null;
	}

	public PkgGroup findByName(String pkgGroupName) {
		List<PkgGroup> list = getHibernateTemplate().find("from PkgGroup where name = ?",
				pkgGroupName);
		if (list.size() > 0)
			return (PkgGroup) list.get(0);
		return null;
	}
	
	public PkgGroup find(String pkgGroupName,Pkg pkg) {
		List<PkgGroup> list = getHibernateTemplate().find("from PkgGroup where name = ? and package_id = ?",
				pkgGroupName, pkg.getId());
		if(list.size() > 0 )
			return (PkgGroup) list.get(0);
		return null;
	}

}
