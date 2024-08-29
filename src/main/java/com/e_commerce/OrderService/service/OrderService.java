package com.e_commerce.OrderService.service;

import com.e_commerce.OrderService.dto.AddOrderDto;
import com.e_commerce.OrderService.dto.OrderDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<String> addOrder(AddOrderDto addOrderDto);
    ResponseEntity<List<OrderDto>> getAllOrders();
    ResponseEntity<OrderDto> getOrderById(Integer id);
}
