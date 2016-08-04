package com.ran.sample.spring.controller;

import com.ran.sample.spring.dto.CategoryDTO;
import com.ran.sample.spring.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryApiController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody CategoryDTO createOrder(@Valid @RequestBody CategoryDTO Category) {
        return categoryService.create(Category);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<CategoryDTO> getByItem(@PathVariable String name) {
        try {
            return new ResponseEntity<CategoryDTO>(categoryService.getByName(name), HttpStatus.OK);
        } catch (EntityNotFoundException entityNotFound) {
            return new ResponseEntity<CategoryDTO>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<CategoryDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}