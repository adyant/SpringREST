package com.shipt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shipt.dao.ApiDaoImpl;
import com.shipt.dao.CategoryDaoImpl;
import com.shipt.dao.CustomerDaoImpl;
import com.shipt.dao.OrderDaoImpl;
import com.shipt.dao.OrderItemDaoImpl;
import com.shipt.dao.ProductDaoImpl;
import com.shipt.service.ApiServiceImpl;

public class DaoFactory {

    public static DaoFactory daoFactory;
    public static CategoryDaoImpl categoryDaoImpl;
    public static CustomerDaoImpl customerDaoImpl;
    public static ProductDaoImpl productDaoImpl;
    public static OrderDaoImpl orderDaoImpl;
    public static OrderItemDaoImpl orderItemDaoImpl;
    public static ApiDaoImpl apiDaoImpl;
    
    private DaoFactory() {
    }

//maling the Hibernate SessionFactory object as singleton
 
    public static CategoryDaoImpl getCategoryDaoImpl() {
		return categoryDaoImpl;
	}

	public static CustomerDaoImpl getCustomerDaoImpl() {
		return customerDaoImpl;
	}

	public static ProductDaoImpl getProductDaoImpl() {
		return productDaoImpl;
	}

	public static OrderDaoImpl getOrderDaoImpl() {
		return orderDaoImpl;
	}

	public static OrderItemDaoImpl getOrderItemDaoImpl() {
		return orderItemDaoImpl;
	}


	public static ApiDaoImpl getApiDaoImpl() {
		return apiDaoImpl;
	}

	public static synchronized DaoFactory getDaoFactory() {
 
        if (daoFactory == null) {
        	daoFactory = new DaoFactory();
        	categoryDaoImpl = new  CategoryDaoImpl();
        	customerDaoImpl = new CustomerDaoImpl();
        	productDaoImpl = new ProductDaoImpl();
        	orderDaoImpl = new OrderDaoImpl();
        	orderItemDaoImpl = new OrderItemDaoImpl();
        	apiDaoImpl = new ApiDaoImpl();
        }
        return daoFactory;
    }
}
