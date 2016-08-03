package com.ran.sample.spring.service;

import com.ran.sample.spring.model.Seller;

import java.util.List;

public interface SellerService {
    List<Seller> getAllSellers();

    Seller createSeller(Seller seller);

    List<Seller> getByName(String name);
}
