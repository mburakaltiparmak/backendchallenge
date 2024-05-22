package com.example.backendchallenge.entity.store;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories",schema = "backendchallenge")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name="code",nullable = false)
    private String code;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "img")
    private String img;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "gender",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="products_categories",schema="backendchallenge",
            joinColumns = @JoinColumn(name="category_id"), inverseJoinColumns = @JoinColumn(name="product_id"))
    private List<Product> productsList;
}
