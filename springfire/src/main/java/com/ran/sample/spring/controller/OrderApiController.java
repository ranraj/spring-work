package com.ran.sample.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ran.sample.spring.model.SaleOrder;
import com.ran.sample.spring.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderApiController {

    @Autowired
    private OrderService orderService;

    // Simple / means fetch all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<SaleOrder> getAllOrder() {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody SaleOrder createOrder(@RequestBody SaleOrder saleOrder) {
        return orderService.createOrder(saleOrder);
    }

    @RequestMapping(value = "/item/{item}", method = RequestMethod.GET)
    public @ResponseBody List<SaleOrder> getByItem(@PathVariable String item) {
        return orderService.getByItem(item);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String singleSave(@RequestParam("file") MultipartFile file, @RequestParam("desc") String desc) {
        String fileName = null;
        if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
                buffStream.write(bytes);
                buffStream.close();
                return "You have successfully uploaded " + fileName;
            } catch (Exception e) {
                return "You failed to upload " + fileName + ": " + e.getMessage();
            }
        } else {
            return "Unable to upload. File is empty.";
        }
    }

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
  
}