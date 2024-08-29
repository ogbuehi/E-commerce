package com.e_commerce.OrderService.controller;

import com.e_commerce.OrderService.dto.AddOrderDto;
import com.e_commerce.OrderService.dto.OrderDto;
import com.e_commerce.OrderService.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/add")
    public ResponseEntity<String> addOrder(@RequestBody AddOrderDto orderDto){
        return orderService.addOrder(orderDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Integer id){
        return orderService.getOrderById(id);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return orderService.getAllOrders();
    }
}
