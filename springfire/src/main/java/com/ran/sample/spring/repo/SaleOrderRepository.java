package com.ran.sample.spring.repo;

import com.ran.sample.spring.model.SaleOrder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleOrderRepository extends JpaRepository<SaleOrder, Long> {
    List<SaleOrder> findByItem(String item);
}
