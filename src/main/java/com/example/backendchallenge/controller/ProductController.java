package com.example.backendchallenge.controller;

import com.example.backendchallenge.entity.store.products.Product;
import com.example.backendchallenge.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping
    public List<Product> getProducts(){
        return productRepository.getProducts();
    }
}
