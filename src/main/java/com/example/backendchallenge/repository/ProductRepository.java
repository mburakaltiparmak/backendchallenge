package com.example.backendchallenge.repository;

import com.example.backendchallenge.entity.store.Category;
import com.example.backendchallenge.entity.store.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

@Query(value = "SELECT * FROM backendchallenge.products",nativeQuery = true)
    List<Product> getProducts();
    List<Product> findByCategory(Category category);
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    Optional<Product> findByName(String name);
}
