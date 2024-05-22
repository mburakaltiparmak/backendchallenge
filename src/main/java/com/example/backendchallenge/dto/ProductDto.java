package com.example.backendchallenge.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productStock;
    private Long productStoreId;
    private Long categoryId;
    private String categoryImg;
    private double productRating;
    private int productSellCount;
    private String imageUrl;
    private int imageIndex;
}
