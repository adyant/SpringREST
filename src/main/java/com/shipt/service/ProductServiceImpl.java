package com.shipt.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shipt.DaoFactory;
import com.shipt.ServiceFactory;
import com.shipt.SessionFactorySingleton;
import com.shipt.model.Category;
import com.shipt.model.Product;

public class ProductServiceImpl implements ProductService {

	@Override
	public Product createProduct(String productName, int unit, int price) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		Product newProduct = DaoFactory.getDaoFactory().getProductDaoImpl().createProduct(productName, unit, price);
		session.getTransaction().commit();
		return newProduct;
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		Product product = DaoFactory.getDaoFactory().getProductDaoImpl().getProduct(id);
		session.getTransaction().commit();
		return product;

	}

	@Override
	public Product updateProduct(int id, String productName, int unit, int price) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		Product product = DaoFactory.getDaoFactory().getProductDaoImpl().updateProduct(id, productName, unit, price);
		session.getTransaction().commit();
		return product;
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		DaoFactory.getDaoFactory().getProductDaoImpl().deleteProduct(id);
		session.getTransaction().commit();
	}

}
