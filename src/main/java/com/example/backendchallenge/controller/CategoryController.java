package com.example.backendchallenge.controller;

import com.example.backendchallenge.entity.store.Category;
import com.example.backendchallenge.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    /*
    @GetMapping
    public List<Category> getAllCategoryData(){
        return categoryRepository.getAllCategoryData();
    }
    @GetMapping("/get")
    public List<String> getCategories() {
        return categoryRepository.getCategories();


    }

     */

}
