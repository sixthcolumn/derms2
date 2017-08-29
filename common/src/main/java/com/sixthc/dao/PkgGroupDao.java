package com.sixthc.dao;

import com.sixthc.model.Pkg;
import com.sixthc.model.PkgGroup;

public interface PkgGroupDao {

	public void save(PkgGroup PkgGroup);

	public void update(PkgGroup PkgGroup);

	public void delete(PkgGroup PkgGroup);

	public PkgGroup findById(int id);

	public PkgGroup findByName(String pkgGroupName);

	public PkgGroup find(String pkgGroupName,Pkg pkg);
}
