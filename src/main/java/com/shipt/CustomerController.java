package com.shipt;

import java.util.concurrent.atomic.AtomicLong;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shipt.ServiceFactory;
import com.shipt.model.Category;
import com.shipt.model.Customer;
import com.shipt.model.ProductWrapper;
import com.shipt.service.CustomerService;
import com.shipt.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
    private static final String template = "Customer id: %s. Customer first name: %s! ";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/create/{name}", method=RequestMethod.POST)
    public Customer postCustomer(@PathVariable(value="name", required=false) String customerName) {
    	Customer newCustomer = ServiceFactory.getServiceFactory().getCustomerServiceImpl().createCustomer(customerName);
    	return newCustomer;
    }
    
    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public Customer getCustomer(@PathVariable(value="id",required=false) int custid) {
    	Customer customer = ServiceFactory.getServiceFactory().getCustomerServiceImpl().getCustomer(custid);
        return customer;
    }

    @RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
    public Customer putCustomer(@PathVariable(value="id", required=false) int catid, @RequestBody Customer customer) {
    	Customer newCustomer = ServiceFactory.getServiceFactory().getCustomerServiceImpl().updateCustomer(catid,customer);
    	return newCustomer;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public Customer deleteCustomer(@PathVariable(value="id", required=false) int custId) {
    	CustomerService customerService = new CustomerServiceImpl();
    	customerService.deleteCustomer(custId);
    	return new Customer(custId,String.format("Customer Id: %s! ", custId));
    }

    @RequestMapping(value="/addOrder/{cId}/{oId}", method=RequestMethod.PUT)
    public Customer addOrder(@PathVariable(value="cId", required=false) int custId,@PathVariable(value="oId", required=false) int orderId) {
    	return ServiceFactory.getServiceFactory().getCustomerServiceImpl().addOrder(custId, orderId);
    }
    
}
