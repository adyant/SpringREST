package com.shipt.dao;

import com.shipt.model.POrder;

public interface OrderDao {

	public POrder createOrder(POrder order);
	
	public POrder getOrder(int id);
	
	public POrder updateOrder(int id, String orderStatus);
	
	public void deleteOrder(int id);
	
}
