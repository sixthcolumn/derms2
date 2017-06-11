package com.sixthc.dao;

import com.sixthc.hbm.NameTypeAuthority;
import com.sixthc.hbm.Nametype;
import com.sixthc.hbm.Organization;
import com.sixthc.hbm.OrganizationNames;

//import com.sixthc.model.Organization;

public interface OrganizationDao {

	public void save(Organization log);
	public void update(Organization log);
	public void delete(Organization log);
	public void saveName(OrganizationNames name);
	public void saveNameTypeAuthority(NameTypeAuthority nt);
	public void saveNameType(Nametype nt);
}
