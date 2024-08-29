package com.e_commerce.OrderService.service;

import com.e_commerce.OrderService.dao.OrderDao;
import com.e_commerce.OrderService.dto.AddOrderDto;
import com.e_commerce.OrderService.dto.OrderDto;
import com.e_commerce.OrderService.dto.ProductDto;
import com.e_commerce.OrderService.feignclient.ProductClient;
import com.e_commerce.OrderService.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderDao orderDao;
    private final ProductClient productClient;
    @Override
    public ResponseEntity<String> addOrder(AddOrderDto addOrderDto) {
        ResponseEntity<ProductDto> product = productClient.getProductsById(
                addOrderDto.getProductId());
        Order order = new Order();
        order.setQuantity(addOrderDto.getQuantity());
        order.setProductId(addOrderDto.getProductId());
        if (product != null){
            orderDao.save(order);
        }else {
            throw new RuntimeException("Product not found");
        }
        return new ResponseEntity<>("Order Placed", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<Order> orders = orderDao.findAll();
        OrderDto orderDto = new OrderDto();
        for (Order order:
             orders) {
            orderDto.setId(order.getId());
            orderDto.setProductId(order.getProductId());
            orderDto.setQuantity(order.getQuantity());
        }
        List<OrderDto> orderDtos = new ArrayList<>();
        orderDtos.add(orderDto);
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDto> getOrderById(Integer id) {
        Order order = orderDao.findById(id).orElse(null);
        OrderDto orderDto = new OrderDto();
        assert order != null;
        orderDto.setId(order.getId());
        orderDto.setProductId(order.getProductId());
        orderDto.setQuantity(order.getQuantity());
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }
}
