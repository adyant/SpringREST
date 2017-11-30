package com.shipt.service;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.shipt.DaoFactory;
import com.shipt.OrderStatusEnum;
import com.shipt.SessionFactorySingleton;
import com.shipt.model.Customer;
import com.shipt.model.OutputCustomerOrder;
import com.shipt.model.OutputQuantity;
import com.shipt.model.OutputSql;

public class ApiServiceImpl implements ApiService{
	
	@Override
	public List<OutputSql> getList() {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		String queryStr = "select c.customer_id, c.customer_first_name, ca.category_id, ca.category_name, sum(oi.quantity) as number_purchased from customer c, category ca, customer_porder cpo, porder_orderitem poi, orderitem oi, category_product cp  where c.customer_id=cpo.customer_customer_id and cpo.orders_order_id = poi.porder_order_id and poi.orderitems_id=oi.product_id and oi.product_id=cp.products_product_id and cp.category_category_id=ca.category_id group by c.customer_id, c.customer_first_name, ca.category_id, ca.category_name";
		Query query = session.createNativeQuery(queryStr);
		List<Object[]> results = query.getResultList();
		
		List<OutputSql> list = new ArrayList<OutputSql>();
		for (Object[] r: results){
			OutputSql customerTempl = new OutputSql();
			customerTempl.setCustomer_id( (int) r[0]);
			customerTempl.setCustomer_first_name( (String) r[1]);
			customerTempl.setCategory_id( (int) r[2]);
			customerTempl.setCategory_name( (String) r[3]);
			customerTempl.setNumber_purchased( (BigInteger) r[4]);
			list.add(customerTempl);
		}		
		session.getTransaction().commit();

		return list;
	}

	@Override
	public List<OutputQuantity> getQuantityByRange(String dayweekmonth, String startDate, String endDate) {
		// TODO Auto-generated method stub
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();


		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		List<OutputQuantity> list = new ArrayList<OutputQuantity>();
		try {
			
		Date sDate = formatter.parse(startDate);
		Date eDate = formatter.parse(endDate);
		String queryStr = "select to_char(date_trunc(:dwm, p.po_date),'MM-dd-yyyy') as dayweekmonth, sum(oi.quantity) as quantity from porder p, orderitem oi, porder_orderitem poi where p.order_id=poi.porder_order_id and poi.orderitems_id= oi.product_id and p.po_date BETWEEN :startDate and :endDate  group by 1 order by 1";
		Query query = session.createNativeQuery(queryStr);
		query.setParameter("dwm", dayweekmonth);
		String dwmname = dayweekmonth;
		//query.setParameter("dwmName", dwmname);		
		query.setParameter("startDate", sDate);
		query.setParameter("endDate", eDate);
		List<Object[]> results = query.getResultList();
		

		for (Object[] r: results){
			OutputQuantity oneBreakDown = new OutputQuantity();
			oneBreakDown.setBreakby((String) r[0] );
			oneBreakDown.setQuantity( (BigInteger) r[1]);
			list.add(oneBreakDown);
		}
		} catch (ParseException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.getTransaction().commit();

		return list;
	}
	
	
	@Override
	public List<OutputCustomerOrder> getCustomerOrders(int custId){
		
		Session session = SessionFactorySingleton.getSessionFactory().getFactorySession();
		session.beginTransaction();
		List<OutputCustomerOrder> results = DaoFactory.getDaoFactory().getApiDaoImpl().getCustomerOrders(custId);
		session.getTransaction().commit();
		return results;
	}


}
