package com.shipt.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
	private String product_name;
	private int unit;
	private int price;
	@ManyToMany
	private Collection<Category> category = new ArrayList<Category>();
	
    public Product() {
		super();
	}

    public Product(int product_id, String product_name, int unit, int price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.unit = unit;
        this.price = price;
    }

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Collection<Category> getCategory() {
		return category;
	}

	public void setCategory(Collection<Category> category) {
		this.category = category;
	}


	
    
    
}
