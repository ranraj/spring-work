package com.ran.sample.spring.service;

import com.ran.sample.spring.dto.SellerDTO;
import com.ran.sample.spring.model.Seller;

import java.util.List;

public interface SellerService {
    List<Seller> getAllSellers();

    SellerDTO createSeller(SellerDTO seller) throws Exception;

    List<Seller> getByName(String name);
}
