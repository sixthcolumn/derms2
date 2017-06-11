package com.sixthc.dao;

import java.util.List;

import com.sixthc.hbm.Maintorder;



public interface MaintOrderDao {

	public void save(Maintorder log);
	public void update(Maintorder log);
	public void delete(Maintorder log);
	//public Maintorder findById(int id);
	//public long getMessageIdSequence();
	public Maintorder find(String mrid);
	public List<Maintorder> findAll();
}
