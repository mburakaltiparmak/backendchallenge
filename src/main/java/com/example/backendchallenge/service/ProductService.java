package com.example.backendchallenge.service;

import com.example.backendchallenge.dto.ProductResponse;
import com.example.backendchallenge.entity.store.Category;
import com.example.backendchallenge.entity.store.Product;

import java.util.List;

public interface ProductService {
    ProductResponse addProduct(Product product);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(Category category);
    ProductResponse getProductByName(String name);
    void deleteProduct(Long id);
}
