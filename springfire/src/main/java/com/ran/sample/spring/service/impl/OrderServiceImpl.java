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
		Orders orders=new OrderFactory().createOrders();
		orders.setCmd("First");
		orders.setEnv("1");
		Order order=new Order();
		order.setOrderId(101);
		order.setTransactions(1);
		orders.setOrder(order);
		return orders;
	}

}
