package com.shipt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.shipt.DaoFactory;
import com.shipt.OrderStatusEnum;
import com.shipt.SessionFactorySingleton;
import com.shipt.model.Customer;
import com.shipt.model.OutputCustomerOrder;

public class ApiDaoImpl implements ApiDao {

	@Override
	public List<OutputCustomerOrder> getCustomerOrders(int custId) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		String queryStr = "select a.order_id,a.order_status,a.order_value,a.customer_customer_id from (select * from porder left join customer_porder on porder.order_id = customer_porder.orders_order_id) as a where a.customer_customer_id= :cid";
		Query query = session.createNativeQuery(queryStr);
		query.setParameter("cid", custId);
		List<Object[]> results = query.getResultList();
		List<OutputCustomerOrder> purchaseOrders = new ArrayList<OutputCustomerOrder>();
		for (Object[] r: results){
			OutputCustomerOrder newOrder = new OutputCustomerOrder();
			newOrder.setOrder_id( (int) r[0]);
			newOrder.setOrder_status( OrderStatusEnum.values()[(int) r[1]] );
			newOrder.setOrder_value((int)r[2]);
			newOrder.setCustomer_id((int)r[3]);
			purchaseOrders.add(newOrder);
		}

		return purchaseOrders;
	
	}


	@Override
	public List<OutputCustomerOrder> getQuantityByRange(int custid) {
		// TODO Auto-generated method stub
		return null;
	}

}
