package com.ran.sample.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ran.sample.spring.model.Category;
import com.ran.sample.spring.repo.CategoryRepository;
import com.ran.sample.spring.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category create(Category category) {		
		return categoryRepository.save(category);
	}
	
	@Override
	public List<Category> getByName(String name) {
		return categoryRepository.findByName(name);
	}
	
	public CategoryRepository getCategoryRepository() {
		return categoryRepository;
	}

	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
}
