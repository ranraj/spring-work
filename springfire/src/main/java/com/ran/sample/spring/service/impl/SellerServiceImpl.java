package com.ran.sample.spring.service.impl;

import com.ran.sample.spring.model.Seller;
import com.ran.sample.spring.repo.SellerRepository;
import com.ran.sample.spring.service.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Seller createSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public List<Seller> getByName(String name) {
        return sellerRepository.findByName(name);
    }

}