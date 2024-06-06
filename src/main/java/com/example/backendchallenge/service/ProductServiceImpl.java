package com.example.backendchallenge.service;

import com.example.backendchallenge.dto.ProductResponse;
import com.example.backendchallenge.entity.store.Category;
import com.example.backendchallenge.entity.store.Product;
import com.example.backendchallenge.exceptions.AuthException;
import com.example.backendchallenge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse addProduct(Product product) {
        Product newProduct = productRepository.save(product);
        return new ProductResponse(newProduct.getName(), newProduct.getCategory().getTitle());
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public ProductResponse getProductByName(String name) {
        Optional<Product> productOptional = productRepository.findByName(name);
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            return new ProductResponse(product.getName(), product.getCategory().getTitle());
        }
        else throw new AuthException("Product not found with this name:" + name, HttpStatus.NOT_FOUND);
    }


    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }
}
