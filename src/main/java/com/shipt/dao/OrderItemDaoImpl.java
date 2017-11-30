package com.shipt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shipt.OrderStatusEnum;
import com.shipt.SessionFactorySingleton;
import com.shipt.model.OrderItem;

public class OrderItemDaoImpl implements OrderItemDao {

	@Override
	public OrderItem createOrderItem(OrderItem newOrderItem) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.save(newOrderItem);
		return newOrderItem;

	}

	@Override
	public OrderItem getOrderItem(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		OrderItem order = (OrderItem) session.get(OrderItem.class,id);
		return order;

	}

	/*@Override
	public OrderItem updateOrderItem(int id, String orderStatus) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		OrderItem order = (OrderItem) session.get(OrderItem.class,id);
		//order.setOrder_status(orderStatus);
		session.save(order);
		return order;
	}*/

	@Override
	public void deleteOrderItem(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		OrderItem order = (OrderItem) session.get(OrderItem.class,id);
		session.delete(order);
	}

}
