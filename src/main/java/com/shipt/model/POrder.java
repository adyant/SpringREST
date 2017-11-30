package com.shipt.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.shipt.OrderStatusEnum;

@Entity
public class POrder {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
	private OrderStatusEnum order_status;
	@OneToMany
	private Collection<OrderItem> orderitems = new ArrayList<OrderItem>();
	private int order_value;
	@Temporal(TemporalType.DATE)
	private Date po_date;
	@Transient
	private int customer_id;

	//list of products will be a variable

    public POrder() {
		super();
	}

    public POrder(int order_id, Collection<OrderItem> orderItems, OrderStatusEnum order_status, int order_value) {
        this.order_id = order_id;
        this.order_status = order_status;
        this.orderitems = orderItems;
        this.order_value = order_value;
    }

    
    
    
	public Date getPo_date() {
		return po_date;
	}

	public void setPo_date(Date po_date) {
		this.po_date = po_date;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public OrderStatusEnum getOrder_status() {
		return order_status;
	}

	public void setOrder_status(OrderStatusEnum order_status) {
		this.order_status = order_status;
	}


	public Collection<OrderItem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(Collection<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getOrder_value() {
		return order_value;
	}

	public void setOrder_value(int order_value) {
		this.order_value = order_value;
	}

    
    
}
