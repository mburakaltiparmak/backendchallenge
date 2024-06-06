package com.example.backendchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreator {
    private String name;
    private String description;
    private double price;
    private int stock;
    private double rating;
    private int sellCount;
    private String size;
    private String[] images;
    private String categoryCode;
}
