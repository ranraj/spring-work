package com.ran.sample.spring.service.impl;

import org.springframework.stereotype.Service;

import com.ran.sample.spring.model.OrderFactory;
import com.ran.sample.spring.model.Orders;
import com.ran.sample.spring.model.Orders.Order;
import com.ran.sample.spring.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public Orders getAllOrders() {
		
		OrderFactory of=new OrderFactory();
		
		Orders orders=of.createOrders();
			Order order=new Order();
			order.setOrderId(11);
			order.setTransactions(1);	 
		orders.setOrder(order);
		
		return orders;
	}

}
