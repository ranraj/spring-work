package com.ran.sample.spring.service;

import java.util.List;

import com.ran.sample.spring.model.Category;

public interface CategoryService {
    List<Category> getAllCategories();

    Category create(Category category);

    List<Category> getByName(String name);
}
