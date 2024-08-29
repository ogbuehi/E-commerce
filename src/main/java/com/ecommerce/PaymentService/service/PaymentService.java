package com.ecommerce.PaymentService.service;

import com.ecommerce.PaymentService.dto.PaymentCreateRequest;
import com.ecommerce.PaymentService.dto.PaymentResponseDto;

public interface PaymentService {
    PaymentResponseDto createPayment(PaymentCreateRequest paymentRequestDTO);
}
