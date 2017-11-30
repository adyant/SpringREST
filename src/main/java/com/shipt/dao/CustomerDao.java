package com.shipt.dao;

import com.shipt.model.Customer;

public interface CustomerDao {

	public Customer createCustomer(String first_name);
	
	public Customer getCustomer(int id);

	public Customer updateCustomer(int id, Customer customer);
	
	public void deleteCustomer(int id);
	
}
