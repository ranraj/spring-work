package com.ran.sample.spring.service.impl;

import com.ran.sample.spring.dto.SellerDTO;
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

    public SellerDTO createSeller(SellerDTO sellerDto) throws Exception {
        Seller seller = null;
        if (sellerDto != null) {
            seller = new Seller();
            seller.setName(sellerDto.getName());
            seller.setItems(sellerDto.getItems());
        } else {
            throw new Exception("Insufficient data");
        }
        seller = sellerRepository.save(seller);
        sellerDto = new SellerDTO();
        sellerDto.setId(seller.getId());
        sellerDto.setName(seller.getName());
        sellerDto.setItems(seller.getItems());
        return sellerDto;
    }

    public List<Seller> getByName(String name) {
        return sellerRepository.findByName(name);
    }

}