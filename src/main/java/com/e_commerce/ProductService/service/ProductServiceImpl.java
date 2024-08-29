package com.e_commerce.ProductService.service;

import com.e_commerce.ProductService.dao.ProductDao;
import com.e_commerce.ProductService.dto.ProductDto;
import com.e_commerce.ProductService.dto.SaveProductDto;
import com.e_commerce.ProductService.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    @Override
    public ResponseEntity<String> addProduct(SaveProductDto productDto) {
        try {
            Product product = new Product();
            product.setName(productDto.getName());
            product.setCategory(productDto.getCategory());
            product.setPrice(productDto.getPrice());
            productDao.save(product);
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("saved", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductDto> findById(Integer id) {
        Product product = productDao.findById(id).orElse(null);
        ProductDto productDto = new ProductDto();
        assert product != null;
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setCategory(product.getCategory());
        productDto.setPrice(product.getPrice());
        return new ResponseEntity<>(productDto, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<ProductDto>> findAll() {
        List<Product> products = productDao.findAll();
        ProductDto productDto = new ProductDto();
        for (Product p:
             products) {
            productDto.setId(p.getId());
            productDto.setName(p.getName());
            productDto.setCategory(p.getCategory());
            productDto.setPrice(p.getPrice());
        }
        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(productDto);
        return new ResponseEntity<>(productDtos, HttpStatus.FOUND);
    }
}
