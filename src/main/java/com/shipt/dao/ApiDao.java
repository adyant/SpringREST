package com.shipt.dao;

import java.util.List;

import com.shipt.model.OutputCustomerOrder;
import com.shipt.model.POrder;

public interface ApiDao {


	public List<OutputCustomerOrder> getQuantityByRange(int custid);
	
	public List<OutputCustomerOrder> getCustomerOrders(int custid);

}
