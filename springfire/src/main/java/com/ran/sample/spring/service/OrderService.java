package com.ran.sample.spring.service;

import com.ran.sample.spring.model.SaleOrder;

import java.util.List;

public interface OrderService {
	List<SaleOrder> getAllOrders();

	SaleOrder createOrder(SaleOrder saleOrder);

	List<SaleOrder> getByItem(String item);

	SaleOrder getOrder(long orderId);

	boolean deleteOrder(long orderId);
	
	SaleOrder updateOrder(SaleOrder saleOrder);
}
