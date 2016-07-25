package com.ran.sample.spring.service;

import java.util.List;

import com.ran.sample.spring.model.SaleItem;

public interface ItemService {
	public List<SaleItem> getAllItems();
	public SaleItem createItem(SaleItem saleItem);
	public List<SaleItem> getByName(String name);
}
