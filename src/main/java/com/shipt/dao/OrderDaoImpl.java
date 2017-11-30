package com.shipt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shipt.OrderStatusEnum;
import com.shipt.SessionFactorySingleton;
import com.shipt.model.POrder;

public class OrderDaoImpl implements OrderDao {

	@Override
	public POrder createOrder(POrder newOrder) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.save(newOrder);
		return newOrder;

	}

	@Override
	public POrder getOrder(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		POrder order = (POrder) session.get(POrder.class,id);
		return order;

	}

	@Override
	public POrder updateOrder(int id, String orderStatus) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		POrder order = (POrder) session.get(POrder.class,id);
		//order.setOrder_status(orderStatus);
		session.save(order);
		return order;
	}

	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		POrder order = (POrder) session.get(POrder.class,id);
		session.delete(order);
	}

}
