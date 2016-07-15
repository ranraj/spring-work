package com.ran.sample.spring.controller;

import com.ran.sample.spring.model.Order;
import com.ran.sample.spring.service.impl.OrderServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderApiController {

    @Autowired
    private OrderServiceImpl orderService;

    // Simple / means fetch all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Order> getAllOrder() {
        return orderService.getAllOrders();
    }

    public OrderServiceImpl getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }
}