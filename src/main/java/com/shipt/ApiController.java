package com.shipt;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.shipt.model.OutputCustomerOrder;
import com.shipt.model.OutputQuantity;
import com.shipt.model.OutputSql;


@RestController
@RequestMapping("/api")
public class ApiController {

	
    @RequestMapping(value="/getList", method=RequestMethod.GET)
    public List<OutputSql> getList() {
    	List<OutputSql> customers = ServiceFactory.getServiceFactory().getApiServiceImpl().getList();
		return customers;
    }
    
    @RequestMapping(value="/getQuantityByRange/{dwm}/{startDate}/{endDate}", method=RequestMethod.GET)
    public List<OutputQuantity> getQuantityByRange(@PathVariable("dwm") String dayweekmonth, @PathVariable(value="startDate",required=false) String startDate, @PathVariable("endDate") String endDate) {
    	
    	List<OutputQuantity> quantityBreakdown = ServiceFactory.getServiceFactory().getApiServiceImpl().getQuantityByRange(dayweekmonth, startDate, endDate);
		return quantityBreakdown;
    }

	
	
    @RequestMapping(value="/getOrdersForCustomer/{id}", method=RequestMethod.GET)
    public List<OutputCustomerOrder> getOrdersForCustomer(@PathVariable(value="id",required=false) int custid) {
    	List<OutputCustomerOrder> purchaseOrders = ServiceFactory.getServiceFactory().getApiServiceImpl().getCustomerOrders(custid);
		return purchaseOrders;
    }


    
	
}
