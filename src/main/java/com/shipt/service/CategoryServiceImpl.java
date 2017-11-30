package com.shipt.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shipt.DaoFactory;
import com.shipt.ServiceFactory;
import com.shipt.SessionFactorySingleton;
import com.shipt.model.Category;
import com.shipt.model.Product;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public Category createCategory(String catName) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		Category newCategory= DaoFactory.getDaoFactory().getCategoryDaoImpl().createCategory(catName);
		session.getTransaction().commit();
		return newCategory;
	}

	@Override
	public Category getCategory(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		Category category = DaoFactory.getDaoFactory().getCategoryDaoImpl().getCategory(id);
		session.getTransaction().commit();
		return category;
	}

	@Override
	public Category updateCategory(int id, String catName) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		Category category = DaoFactory.getDaoFactory().getCategoryDaoImpl().updateCategory(id,catName);
		session.getTransaction().commit();
		return category;
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		DaoFactory.getDaoFactory().getCategoryDaoImpl().deleteCategory(id);
		session.getTransaction().commit();
	}

	@Override
	public Category addProduct(int catid, Product product) {
		// TODO Auto-generated method stub

		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		Category category = DaoFactory.getDaoFactory().getCategoryDaoImpl().getCategory(catid);
		List<Product> products = (List<Product>) category.getProducts();
		if (products==null) products = new ArrayList<Product>();
		Product newproduct = DaoFactory.getDaoFactory().getProductDaoImpl().getProductByDesc(product.getProduct_name());
		if (newproduct==null) {
			newproduct = DaoFactory.getDaoFactory().getProductDaoImpl().createProduct(
				product.getProduct_name(),product.getUnit(),product.getPrice());
		}
		products.add(newproduct);
		session.getTransaction().commit();
		return category;
	}

}
