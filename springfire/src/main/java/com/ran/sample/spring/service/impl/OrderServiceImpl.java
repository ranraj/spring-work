package com.ran.sample.spring.service.impl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ran.sample.spring.model.Orders;
import com.ran.sample.spring.service.OrderService;
import com.ran.sample.spring.utils.XMLParser;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	@Qualifier(value="contents")
	private InputStream contents;
	
	@Autowired
	private XMLParser xmlParser;
	
	@Override
	public Orders getAllOrders() {						
		Orders orders=xmlParser.readObject(contents);		 
		return orders;
	}

}
