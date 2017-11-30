package com.shipt.dao;

import com.shipt.model.Product;

public interface ProductDao {

	public Product createProduct(String productName, int unit, int price);
	
	public Product getProduct(int id);
	
	public Product updateProduct(int id,String productName, int unit, int price);
	
	public void deleteProduct(int id);
	
	public Product getProductByDesc(String productDesc);
	
}
