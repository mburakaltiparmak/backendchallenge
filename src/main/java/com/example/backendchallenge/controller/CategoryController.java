package com.example.backendchallenge.controller;

import com.example.backendchallenge.entity.categories.Category;
import com.example.backendchallenge.repository.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @GetMapping
    public List<Category> getAllCategoryData(){
        return categoryRepository.getAllCategoryData();
    }
    @GetMapping("/data")
    public List<Category> getCategories(){
        return categoryRepository.getCategories();
    }

}
