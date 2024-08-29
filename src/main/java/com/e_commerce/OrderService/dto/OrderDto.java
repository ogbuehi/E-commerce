package com.e_commerce.OrderService.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Integer id;
    private Integer productId;
    private Integer quantity;
}
