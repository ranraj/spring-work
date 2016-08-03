package com.ran.sample.spring.controller;

import com.ran.sample.spring.dto.SellerDTO;
import com.ran.sample.spring.model.Seller;
import com.ran.sample.spring.service.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerApiController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Seller> getAllOrder() {
        return sellerService.getAllSellers();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<SellerDTO> createSeller(@Valid @RequestBody SellerDTO sellerDto) {
        try {
            return new ResponseEntity<SellerDTO>(sellerService.createSeller(sellerDto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<SellerDTO>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public @ResponseBody List<Seller> getByName(@PathVariable String name) {
        return sellerService.getByName(name);
    }

    public SellerService getSellerService() {
        return sellerService;
    }

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }
}