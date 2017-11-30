package com.shipt.model;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Customer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
	private String customer_first_name;
	@OneToMany
	private Collection<POrder> orders = new ArrayList<POrder>();
	
    public Customer() {
		super();
	}

    public Customer(int customer_id, String customer_first_name) {
        this.customer_id = customer_id;
        this.customer_first_name = customer_first_name;
    }

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

	public Collection<POrder> getOrders() {
		return orders;
	}

	public void setOrders(Collection<POrder> orders) {
		this.orders = orders;
	}



}
