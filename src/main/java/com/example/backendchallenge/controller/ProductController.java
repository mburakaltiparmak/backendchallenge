package com.example.backendchallenge.controller;

import com.example.backendchallenge.dto.ProductDto;
import com.example.backendchallenge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    /*
    @GetMapping
    public List<ProductDto> getProducts() {
        return productRepository.getProducts();


    }

     */
}
