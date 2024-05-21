package com.example.backendchallenge.entity.store.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name = "images")
    private List<Images> images;

}
