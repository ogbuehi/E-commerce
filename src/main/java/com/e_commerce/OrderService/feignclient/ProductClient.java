package com.e_commerce.OrderService.feignclient;

import com.e_commerce.OrderService.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product-service")
public interface ProductClient {
    @GetMapping("/products/{id}")
    ResponseEntity<ProductDto> getProductsById(@PathVariable Integer id);

}
