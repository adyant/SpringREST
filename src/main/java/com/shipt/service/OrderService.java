package com.shipt.service;

import java.util.List;

import com.shipt.model.POrder;
import com.shipt.model.OrderItem;

public interface OrderService {

	public POrder createOrder(List<OrderItem> orderItems);
	
	public POrder getOrder(int id);
	
	public POrder updateOrder(int id, String orderStatus);
	
	public void deleteOrder(int id);
	
}
