package com.ran.sample.spring.model;

import java.util.ArrayList;
import java.util.List;

public class OrderFactory {
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public OrderFactory() {
    }

    public Order createOrder() {
        return new Order();
    }

    public List<Order> createOrders() {
        return new ArrayList<Order>();
    }
}
