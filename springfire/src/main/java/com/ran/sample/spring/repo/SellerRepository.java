package com.ran.sample.spring.repo;

import com.ran.sample.spring.model.Seller;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    List<Seller> findByName(String name);
}
