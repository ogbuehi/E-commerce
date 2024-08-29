package com.e_commerce.ProductService.controller;

import com.e_commerce.ProductService.dto.ProductDto;
import com.e_commerce.ProductService.dto.SaveProductDto;
import com.e_commerce.ProductService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody SaveProductDto saveProductDto){
        return productService.addProduct(saveProductDto);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<ProductDto> findProduct(@PathVariable Integer id){
        return productService.findById(id);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return productService.findAll();
    }
}
