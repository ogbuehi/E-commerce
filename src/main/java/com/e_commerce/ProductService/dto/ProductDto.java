package com.e_commerce.ProductService.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String name;
    private String category;
    private double price;
}
