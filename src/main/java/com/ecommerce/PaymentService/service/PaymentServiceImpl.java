package com.ecommerce.PaymentService.service;

import com.ecommerce.PaymentService.dao.PaymentDao;
import com.ecommerce.PaymentService.dto.PaymentCreateRequest;
import com.ecommerce.PaymentService.dto.PaymentResponseDto;
import com.ecommerce.PaymentService.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDao paymentDao;

    @Override
    public PaymentResponseDto createPayment(PaymentCreateRequest paymentRequestDTO) {
        Payment payment = convertToEntity(paymentRequestDTO);
        Payment savedPayment = paymentDao.save(payment);
        return convertToResponseDTO(savedPayment);
    }
    private Payment convertToEntity(PaymentCreateRequest paymentRequestDTO) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(paymentRequestDTO, payment);
        return payment;
    }

    private PaymentResponseDto convertToResponseDTO(Payment payment) {
        PaymentResponseDto responseDTO = new PaymentResponseDto();
        BeanUtils.copyProperties(payment, responseDTO);
        return responseDTO;
    }
}
