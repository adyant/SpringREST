package com.shipt.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shipt.DaoFactory;
import com.shipt.OrderStatusEnum;
import com.shipt.SessionFactorySingleton;
import com.shipt.model.POrder;
import com.shipt.model.OrderItem;

public class OrderServiceImpl implements OrderService {

	@Override
	public POrder createOrder(List<OrderItem> orderItems) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		POrder order = new POrder();
    	int amt = 0;
    	int price;
    	for (OrderItem oi : orderItems){
    		price =  DaoFactory.getDaoFactory().getProductDaoImpl().getProduct(oi.getProduct_id()).getPrice();
    		amt += oi.getQuantity() * price;
    		oi.setValue(amt);
    		DaoFactory.getDaoFactory().getOrderItemDaoImpl().createOrderItem(oi);
    	}
		order.setOrderitems(orderItems);
		order.setOrder_value(amt);		
		order.setOrder_status(OrderStatusEnum.PLACED);
		POrder newOrder = DaoFactory.getDaoFactory().getOrderDaoImpl().createOrder(order);

		session.getTransaction().commit();
		return newOrder;
	}

	@Override
	public POrder getOrder(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		POrder order = DaoFactory.getDaoFactory().getOrderDaoImpl().getOrder(id);
		session.getTransaction().commit();
		return order;
	}

	@Override
	public POrder updateOrder(int id, String orderStatus) {
		// TODO Auto-generated method stub
		System.out.println("put");
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		POrder order = DaoFactory.getDaoFactory().getOrderDaoImpl().updateOrder(id, orderStatus);
		session.getTransaction().commit();
		return order;
	}

	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		DaoFactory.getDaoFactory().getOrderDaoImpl().deleteOrder(id);
		session.getTransaction().commit();
	}

}
