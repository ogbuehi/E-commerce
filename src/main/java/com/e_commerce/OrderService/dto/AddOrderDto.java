package com.e_commerce.OrderService.dto;

import lombok.Data;

@Data
public class AddOrderDto {
    private Integer productId;
    private Integer quantity;
}
