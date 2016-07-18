package com.ran.sample.spring.controller;

import com.ran.sample.spring.model.SaleOrder;
import com.ran.sample.spring.service.impl.OrderServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderApiController {

    @Autowired
    private OrderServiceImpl orderService;

    // Simple / means fetch all
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<SaleOrder> getAllOrder() {
        return orderService.getAllOrders();
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

    public OrderServiceImpl getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }
}