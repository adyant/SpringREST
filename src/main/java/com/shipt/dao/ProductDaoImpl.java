package com.shipt.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shipt.SessionFactorySingleton;
import com.shipt.model.Category;
import com.shipt.model.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public Product createProduct(String productName, int unit, int price) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		Product newProduct = new Product();
		newProduct.setProduct_name(productName);
		newProduct.setUnit(unit);
		newProduct.setPrice(price);
		session.save(newProduct);
		return newProduct;
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		Product product = (Product) session.get(Product.class,id);
		return product;

	}

	@Override
	public Product updateProduct(int id, String productName, int unit, int price) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		Product product = (Product) session.get(Product.class,id);
		product.setProduct_name(productName);
		product.setUnit(unit);
		product.setPrice(price);	
		session.save(product);
		return product;
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		Product product = (Product) session.get(Product.class,id);
		session.delete(product);
	}

	@Override
	public Product getProductByDesc(String productDesc) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		String hql = "FROM " + Product.class.getName() + " pr WHERE pr.product_name = :pDesc";
		Query query = session.createQuery(hql);
		query.setParameter("pDesc", productDesc);
		Product productReturn = null;
		List<Product> products = (List<Product>) query.getResultList();
		if (products.size() !=0){
			productReturn = products.get(0);
		}
		return productReturn;
	
	}

}
