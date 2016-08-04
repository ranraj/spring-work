package com.ran.sample.spring.service;

import com.ran.sample.spring.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();

    CategoryDTO create(CategoryDTO category);

    CategoryDTO getByName(String name) throws Exception;
}
