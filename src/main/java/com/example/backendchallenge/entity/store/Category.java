package com.example.backendchallenge.entity.store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category",schema = "backendchallenge")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name="code",nullable = false)
    private String code;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "gender",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category",fetch = FetchType.EAGER)
    @JsonIgnoreProperties("category")
    private List<Product> productsList;

}
