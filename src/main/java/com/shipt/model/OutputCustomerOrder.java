package com.shipt.model;


import com.shipt.OrderStatusEnum;

public class OutputCustomerOrder {
    private int order_id;
	private OrderStatusEnum order_status;
	private int order_value;
	private int customer_id;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public OrderStatusEnum getOrder_status() {
		return order_status;
	}
	public void setOrder_status(OrderStatusEnum order_status) {
		this.order_status = order_status;
	}
	public int getOrder_value() {
		return order_value;
	}
	public void setOrder_value(int order_value) {
		this.order_value = order_value;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	
	
}
