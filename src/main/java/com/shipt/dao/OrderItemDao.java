package com.shipt.dao;

import com.shipt.model.OrderItem;

public interface OrderItemDao {

	public OrderItem createOrderItem(OrderItem order);
	
	public OrderItem getOrderItem(int id);
	
	//public OrderItem updateOrder(int id, String orderStatus);
	
	public void deleteOrderItem(int id);
	
}
