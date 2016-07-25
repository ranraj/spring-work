package com.ran.sample.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ran.sample.spring.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);
}
