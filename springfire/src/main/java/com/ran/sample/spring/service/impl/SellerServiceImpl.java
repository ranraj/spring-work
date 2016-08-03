package com.ran.sample.spring.service.impl;

import com.ran.sample.spring.dto.SellerDTO;
import com.ran.sample.spring.model.Seller;
import com.ran.sample.spring.repo.SellerRepository;
import com.ran.sample.spring.service.SellerService;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public SellerDTO createSeller(SellerDTO sellerDto) throws Exception {
        Seller seller = null;
        if (sellerDto != null) {
            seller = dozerBeanMapper.map(sellerDto, Seller.class);
        } else {
            throw new Exception("Insufficient data");
        }
        seller = sellerRepository.save(seller);
        sellerDto = dozerBeanMapper.map(seller, SellerDTO.class);

        return sellerDto;
    }

    public List<Seller> getByName(String name) {
        return sellerRepository.findByName(name);
    }

}