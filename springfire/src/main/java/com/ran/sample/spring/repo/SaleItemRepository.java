package com.ran.sample.spring.repo;

import com.ran.sample.spring.model.SaleItem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
    List<SaleItem> findByName(String name);
}
