package com.shipt;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shipt.model.POrder;
import com.shipt.model.OrderItem;
import com.shipt.model.OrderItemWrapper;
import com.shipt.service.OrderService;
import com.shipt.service.OrderServiceImpl;

@RestController
@RequestMapping("/order")
public class OrderController {

	
    private static final String template = "Order id: %s. Order status: %s! ";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public POrder getOrder(@PathVariable(value="id",required=false) int orderid) {
    	POrder newOrder = ServiceFactory.getServiceFactory().getOrderServiceImpl().getOrder(orderid);
        return newOrder;
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public POrder postOrder(@RequestBody OrderItemWrapper orderitems) {
    	POrder newOrder = ServiceFactory.getServiceFactory().getOrderServiceImpl().createOrder(orderitems.getOrderItems());
    	return newOrder;
    }
    
    @RequestMapping(value="/put/{id}/{name}", method=RequestMethod.PUT)
    public POrder putOrder(@PathVariable(value="id", required=false) int orderid, @PathVariable(value="name", required=false) String orderStatus) {
    	POrder newOrder = ServiceFactory.getServiceFactory().getOrderServiceImpl().updateOrder(orderid,orderStatus);
    	return newOrder;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public POrder deleteOrder(@PathVariable(value="id", required=false) int orderid) {
    	ServiceFactory.getServiceFactory().getOrderServiceImpl().deleteOrder(orderid);
    	POrder delOrder = new POrder();
    	delOrder.setOrder_id(orderid);
    	return delOrder;
    }
	    
    

}
