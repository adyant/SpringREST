package com.shipt.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.shipt.SessionFactorySingleton;
import com.shipt.model.Customer;
import com.shipt.model.OutputCustomerOrder;
import com.shipt.model.OutputQuantity;
import com.shipt.model.OutputSql;
import com.shipt.model.POrder;

public interface ApiService {

	public List<OutputSql> getList();

	public List<OutputQuantity> getQuantityByRange(String dayweekmonth, String startDate, String endDate);
	
	public List<OutputCustomerOrder> getCustomerOrders(int custid);
	

	

}
