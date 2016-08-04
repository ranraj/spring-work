package com.ran.sample.spring.service.impl;

import com.ran.sample.spring.dto.CategoryDTO;
import com.ran.sample.spring.model.Category;
import com.ran.sample.spring.repo.CategoryRepository;
import com.ran.sample.spring.service.CategoryService;
import com.ran.sample.spring.utils.DozerHelper;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    public List<CategoryDTO> getAllCategories() {
        List<Category> category = categoryRepository.findAll();
        List<CategoryDTO> categoryDTO = null;
        categoryDTO = DozerHelper.map(dozerBeanMapper, category, CategoryDTO.class, "categoryList");
        return categoryDTO;
    }

    /*
     * @Override
     * public CategoryDTO create(CategoryDTO category) {
     * return categoryRepository.save(category);
     * }
     * 
     * @Override
     * public List<CategoryDTO> getByName(String name) {
     * return categoryRepository.findByName(name);
     * }
     */
    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO create(CategoryDTO categoryDTO) {
        Category category = dozerBeanMapper.map(categoryDTO, Category.class);
        category = categoryRepository.save(category);
        categoryDTO = dozerBeanMapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }

    public CategoryDTO getByName(String name) throws Exception {
        List<Category> categories = categoryRepository.findByName(name);
        Optional<Category> category = categories.stream().findFirst();
        if (category.isPresent()) {
            CategoryDTO categoryDTO = dozerBeanMapper.map(category.get(), CategoryDTO.class);
            return categoryDTO;
        } else {
            throw new EntityNotFoundException("Enity not found for requested name : " + name);
        }
    }

}
