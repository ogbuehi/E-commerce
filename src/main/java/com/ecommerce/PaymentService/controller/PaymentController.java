package com.ecommerce.PaymentService.controller;

import com.ecommerce.PaymentService.dto.PaymentCreateRequest;
import com.ecommerce.PaymentService.dto.PaymentResponseDto;
import com.ecommerce.PaymentService.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    @PostMapping("/create")
    public ResponseEntity<PaymentResponseDto> createPayment(@RequestBody PaymentCreateRequest paymentRequestDTO) {
        PaymentResponseDto createdPayment = paymentService.createPayment(paymentRequestDTO);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }
}
