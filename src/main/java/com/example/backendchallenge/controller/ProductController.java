package com.example.backendchallenge.controller;

import com.example.backendchallenge.dto.ProductCreator;
import com.example.backendchallenge.dto.ProductResponse;
import com.example.backendchallenge.entity.store.Product;
import com.example.backendchallenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/new")
    public ProductResponse createProduct(@RequestBody ProductCreator productCreator){
        return productService.addProduct(productCreator);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
