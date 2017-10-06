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
        return saleOrderRepository.saveAndFlush(saleOrder);
    }

    @Override
    public List<SaleOrder> getByItem(String item) {
        return saleOrderRepository.findByItem(item);
    }

	@Override
	public boolean deleteOrder(long orderId) {
		SaleOrder temp = saleOrderRepository.findOne(orderId);
		if(temp!=null){
			saleOrderRepository.delete(orderId);
			 return true;
		}
		return false;
	}

	@Override
	public SaleOrder getOrder(long orderId) {
		return saleOrderRepository.findOne(orderId);
	}

	@Override
	public SaleOrder updateOrder(SaleOrder saleOrder) {
		return saleOrderRepository.save(saleOrder);
	}
}