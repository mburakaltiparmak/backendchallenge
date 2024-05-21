package com.example.backendchallenge.repository;

import com.example.backendchallenge.entity.store.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT p.id AS product_id,p.name AS product_name,p.description AS product_description,p.price AS product_price,p.stock AS product_stock,p.store_id AS product_store_id,c.id AS category_id,c.img AS category_img,p.rating AS product_rating, p.sell_count AS product_sell_count, i.url AS image_url, i.index AS image_index FROM backendchallenge.products p LEFT JOIN backendchallenge.categories c ON p.category_id = c.id LEFT JOIN backendchallenge.images i ON p.id = i.product_id")
    List<Product> getProducts();
}
