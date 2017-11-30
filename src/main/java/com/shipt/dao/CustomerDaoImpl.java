package com.shipt.dao;

import org.hibernate.Session;


import com.shipt.SessionFactorySingleton;
import com.shipt.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer createCustomer(String first_name) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		Customer newCustomer = new Customer();
		newCustomer.setCustomer_first_name(first_name);
		session.save(newCustomer);
		return newCustomer;
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		Customer customer = (Customer) session.get(Customer.class,id);
		return customer;
	}

	@Override
	public Customer updateCustomer(int id, Customer newCustomer) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		Customer customer = (Customer) session.get(Customer.class,id);
		customer.setCustomer_first_name(newCustomer.getCustomer_first_name());
		customer.setOrders(newCustomer.getOrders());
		session.save(customer);
		return customer;

	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		Customer customer = (Customer) session.get(Customer.class,id);
		session.delete(customer);
		
	}

}
