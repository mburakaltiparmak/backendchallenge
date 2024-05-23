package com.example.backendchallenge.repository;

import com.example.backendchallenge.entity.store.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

@Query(value = "SELECT * FROM backendchallenge.products",nativeQuery = true)
    List<Product> getProducts();
}
