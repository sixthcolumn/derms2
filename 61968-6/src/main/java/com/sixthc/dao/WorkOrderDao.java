package com.sixthc.dao;

import com.sixthc.hbm.WorkOrder;

//import com.sixthc.model.WorkOrder;

public interface WorkOrderDao {

	public void save(WorkOrder log);

	public void update(WorkOrder log);

	public void delete(WorkOrder log);

	//public WorkOrder findById(int id);
	//public long getMessageIdSequence();
	public WorkOrder find(String mrid);
	public void deleteWorkOrder(String mrid);
}
