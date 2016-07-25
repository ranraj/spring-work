package com.ran.sample.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ran.sample.spring.model.Category;
import com.ran.sample.spring.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryApiController {

    @Autowired
    private CategoryService categoryService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Category createOrder(@RequestBody Category Category) {
        return categoryService.create(Category);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public @ResponseBody List<Category> getByItem(@PathVariable String name) {
        return categoryService.getByName(name);
    }
}