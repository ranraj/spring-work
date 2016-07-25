package com.ran.sample.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ran.sample.spring.model.SaleItem;
import com.ran.sample.spring.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemApiController {

    @Autowired
    private ItemService itemService;

    // Simple / means fetch all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<SaleItem> getAllOrder() {
        return itemService.getAllItems();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody SaleItem createOrder(@RequestBody SaleItem saleOrder) {
        return itemService.createItem(saleOrder);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public @ResponseBody List<SaleItem> getByItem(@PathVariable String name) {
        return itemService.getByName(name);
    }

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
   
}