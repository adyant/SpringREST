package com.shipt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shipt.DaoFactory;
import com.shipt.SessionFactorySingleton;
import com.shipt.model.Category;
import com.shipt.model.Product;
import com.shipt.model.ProductWrapper;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public Category createCategory(String catName) {
		// TODO Auto-generated method stub
		System.out.println("post");
		Category newCategory = new Category();
		newCategory.setCategory_name(catName);
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.save(newCategory);

		return newCategory;
		
	}

	@Override
	public Category getCategory(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		Category category = (Category) session.get(Category.class,id);
		return category;
	}

	@Override
	public Category updateCategory(int id, String catName) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		Category category = (Category) session.get(Category.class,id);
		category.setCategory_name(catName);
		session.save(category);
		return category;
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		Category category = (Category) session.get(Category.class,id);
		session.delete(category);
	}
	
}
