package com.sixthc.dao;

import com.sixthc.model.Message;
import com.sixthc.model.PkgGroup;

public interface MessageDao {

	public void save(Message face);
	public void update(Message face);
	public void delete(Message face);
	public Message findById(int id);
	public Message findByName(String name);
	public Message find(String name, PkgGroup pkgGroup);
}
