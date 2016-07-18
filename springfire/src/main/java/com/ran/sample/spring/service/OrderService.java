package com.ran.sample.spring.service;

import com.ran.sample.spring.model.SaleOrder;

import java.util.List;

public interface OrderService {
    List<SaleOrder> getAllOrders();
}
