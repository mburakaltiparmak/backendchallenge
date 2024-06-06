package com.example.backendchallenge.repository;

import com.example.backendchallenge.entity.store.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository <Category,Long> {

    @Query(value = "SELECT * FROM backendchallenge.category",nativeQuery = true)
    List<Category> getAllCategoryData();
    @Query(value = "SELECT CONCAT(c.title,'-',c.gender) AS category FROM backendchallenge.category c GROUP BY c.title,c.gender", nativeQuery = true)
    List<String> getCategoriesByGender();
    Optional<Category> findByCode(String code);
}
