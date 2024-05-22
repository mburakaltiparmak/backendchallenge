package com.example.backendchallenge.repository;

import com.example.backendchallenge.dto.ProductDto;
import com.example.backendchallenge.entity.store.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    /*

    @Query("SELECT new com.example.backendchallenge.dto.ProductDto(p.id, p.name, p.description, p.price, p.stock, p.store.id, c.id, c.img, p.rating, p.sellCount, i.url, i.index) " +
            "FROM Product p " +
            "LEFT JOIN p.category c " +
            "LEFT JOIN p.images i")
    List<ProductDto> getProducts();
    */

}
