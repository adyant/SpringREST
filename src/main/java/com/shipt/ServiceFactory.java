package com.shipt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shipt.service.ApiServiceImpl;
import com.shipt.service.CategoryServiceImpl;
import com.shipt.service.CustomerServiceImpl;
import com.shipt.service.OrderServiceImpl;
import com.shipt.service.ProductServiceImpl;

public class ServiceFactory {

    public static ServiceFactory serviceFactory;
    public static CategoryServiceImpl categoryServiceImpl;
    public static CustomerServiceImpl customerServiceImpl;
    public static ProductServiceImpl productServiceImpl;
    public static OrderServiceImpl orderServiceImpl;
    public static ApiServiceImpl apiServiceImpl;

    
    private ServiceFactory() {
    }
    
    
    
    
//maling the Hibernate SessionFactory object as singleton
 
    public static CategoryServiceImpl getCategoryServiceImpl() {
		return categoryServiceImpl;
	}

	public static CustomerServiceImpl getCustomerServiceImpl() {
		return customerServiceImpl;
	}

	public static ProductServiceImpl getProductServiceImpl() {
		return productServiceImpl;
	}

	public static OrderServiceImpl getOrderServiceImpl() {
		return orderServiceImpl;
	}
	
	public static ApiServiceImpl getApiServiceImpl() {
		return apiServiceImpl;
	}


	public static synchronized ServiceFactory getServiceFactory() {
 
        if (serviceFactory == null) {
        	serviceFactory = new ServiceFactory();
        	categoryServiceImpl = new  CategoryServiceImpl();
        	customerServiceImpl = new CustomerServiceImpl();
        	productServiceImpl = new ProductServiceImpl();
        	orderServiceImpl = new OrderServiceImpl();
        	apiServiceImpl = new ApiServiceImpl();
        }
        return serviceFactory;
    }
}
