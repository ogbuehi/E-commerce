package com.e_commerce.ProductService.dto;

import lombok.Data;

@Data
public class SaveProductDto {
    private String name;
    private String category;
    private double price;
}
