package com.example.backendchallenge.repository;

import com.example.backendchallenge.entity.store.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository <Category,Long> {

    @Query(value = "SELECT * FROM backendchallenge.categories",nativeQuery = true)
    List<Category> getAllCategoryData();
    @Query(value = "SELECT CONCAT(c.title,'-',c.gender) AS category FROM backendchallenge.categories c GROUP BY c.title,c.gender", nativeQuery = true)
    List<String> getCategories();

}
