package com.ran.sample.spring.service.impl;

import com.ran.sample.spring.model.Order;
import com.ran.sample.spring.model.OrderFactory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public List<Order> getAllOrders() {

        OrderFactory of = new OrderFactory();
        Order order = of.createOrder();

        order.setOrderId(11);
        order.setTransactions(1);

        List<Order> orders = of.createOrders();
        orders.add(order);
        return orders;
    }

}