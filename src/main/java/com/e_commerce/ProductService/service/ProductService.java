package com.e_commerce.ProductService.service;

import com.e_commerce.ProductService.dto.ProductDto;
import com.e_commerce.ProductService.dto.SaveProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<String> addProduct(SaveProductDto productDto);
    ResponseEntity<ProductDto> findById(Integer id);
    ResponseEntity<List<ProductDto>> findAll();
}
