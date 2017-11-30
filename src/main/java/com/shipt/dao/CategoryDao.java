package com.shipt.dao;

import java.util.List;

import com.shipt.model.Category;
import com.shipt.model.Product;

public interface CategoryDao {

	public Category createCategory(String catName);
	
	public Category getCategory(int id);
	
	public Category updateCategory(int id, String catName);
	
	public void deleteCategory(int id);
	
	//public Category addProduct(int catid, Product product);
}
