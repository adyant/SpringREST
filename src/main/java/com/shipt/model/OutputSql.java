package com.shipt.model;

import java.math.BigInteger;

public class OutputSql {
	
    private int customer_id;
	private String customer_first_name;
    private int category_id;
	private String category_name;
	private BigInteger number_purchased;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_first_name() {
		return customer_first_name;
	}
	public void setCustomer_first_name(String customer_first_name) {
		this.customer_first_name = customer_first_name;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public BigInteger getNumber_purchased() {
		return number_purchased;
	}
	public void setNumber_purchased(BigInteger r) {
		this.number_purchased = r;
	}
	
	
	

}
