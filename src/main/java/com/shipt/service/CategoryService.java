package com.shipt.service;

import com.shipt.model.Category;
import com.shipt.model.Product;

public interface CategoryService {
	public Category createCategory(String catName);
	
	public Category getCategory(int id);
	
	public Category updateCategory(int id, String catName);
	
	public void deleteCategory(int id);
	
	public Category addProduct(int catid, Product product);
}
