package com.ran.sample.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ran.sample.spring.model.SaleItem;
import com.ran.sample.spring.repo.SaleItemRepository;
import com.ran.sample.spring.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private SaleItemRepository saleItemRespository;

	@Override
	public List<SaleItem> getAllItems() {
		
		return saleItemRespository.findAll();
	}

	@Override
	public SaleItem createItem(SaleItem saleItem) {		
		return saleItemRespository.save(saleItem);
	}

	@Override
	public List<SaleItem> getByName(String name) {		
		return saleItemRespository.findByName(name);
	}

}