package com.shipt.service;

import org.hibernate.Session;

import com.shipt.DaoFactory;
import com.shipt.SessionFactorySingleton;
import com.shipt.model.Category;
import com.shipt.model.Customer;
import com.shipt.model.POrder;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public Customer createCustomer(String first_name) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		Customer newCustomer = DaoFactory.getDaoFactory().getCustomerDaoImpl().createCustomer(first_name);
		session.getTransaction().commit();
		return newCustomer;

	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		Customer customer = DaoFactory.getDaoFactory().getCustomerDaoImpl().getCustomer(id);
		session.getTransaction().commit();
		return customer;
	}

	@Override
	public Customer updateCustomer(int id, Customer newCustomer) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		Customer customer = DaoFactory.getDaoFactory().getCustomerDaoImpl().updateCustomer(id, newCustomer);
		session.getTransaction().commit();
		return customer;

	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		DaoFactory.getDaoFactory().getCustomerDaoImpl().deleteCustomer(id);
		session.getTransaction().commit();
	}

	@Override
	public Customer addOrder(int custId, int orderId) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		Customer customer = DaoFactory.getDaoFactory().getCustomerDaoImpl().getCustomer(custId);
		POrder order =  DaoFactory.getDaoFactory().getOrderDaoImpl().getOrder(orderId);
		customer.getOrders().add(order);
		Customer updCustomer = DaoFactory.getDaoFactory().getCustomerDaoImpl().updateCustomer(custId, customer);
		session.getTransaction().commit();
		return updCustomer;
	}

}
