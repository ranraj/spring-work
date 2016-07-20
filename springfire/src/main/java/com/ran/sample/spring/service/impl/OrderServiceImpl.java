package com.ran.sample.spring.service.impl;

import com.ran.sample.spring.model.SaleOrder;
import com.ran.sample.spring.repo.SaleOrderRepository;
import com.ran.sample.spring.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private SaleOrderRepository saleOrderRepository;

    @Override
    public List<SaleOrder> getAllOrders() {
        return saleOrderRepository.findAll();
    }

    @Override
    public SaleOrder createOrder(SaleOrder saleOrder) {
        return saleOrderRepository.save(saleOrder);
    }

    @Override
    public List<SaleOrder> getByItem(String item) {
        return saleOrderRepository.findByItem(item);
    }
}