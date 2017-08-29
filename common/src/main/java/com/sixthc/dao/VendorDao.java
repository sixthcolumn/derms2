package com.sixthc.dao;

import com.sixthc.model.Vendor;

public interface VendorDao {

	public void save(Vendor Vendor);
	public void update(Vendor Vendor);
	public void delete(Vendor Vendor);
	public Vendor findById(int id);
	public Vendor findByName(String name);
}
