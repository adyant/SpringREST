package com.shipt.service;

import com.shipt.model.Customer;

public interface CustomerService {

	public Customer createCustomer(String first_name);
	
	public Customer getCustomer(int id);

	public Customer updateCustomer(int id, Customer newCustomer);
	
	public void deleteCustomer(int id);
	
	public Customer addOrder(int custId, int orderId);
}
