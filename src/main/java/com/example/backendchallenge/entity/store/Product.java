package com.example.backendchallenge.entity.store;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products",schema = "backendchallenge")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price",nullable = false)
    private double price;
    @Column(name = "stock",nullable = false)
    private int stock;
    @Column(name = "rating")
    private double rating;
    @Column(name = "sell_count")
    private int sell_count;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="products_categories",schema="backendchallenge",
            joinColumns = @JoinColumn(name="product_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")
    )
    private List<Category> categoriesList;
    public void addCategories(Category category){
        if(categoriesList == null){
            categoriesList = new ArrayList<>();
        }
        categoriesList.add(category);
    }


}
