package com.shipt.service;

import com.shipt.model.Product;

public interface ProductService {

	public Product createProduct(String productName, int unit, int price);
	
	public Product getProduct(int id);
	
	public Product updateProduct(int id,String productName, int unit, int price);
	
	public void deleteProduct(int id);
	
}
