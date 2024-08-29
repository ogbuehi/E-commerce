package com.ecommerce.PaymentService.dao;

import com.ecommerce.PaymentService.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDao extends JpaRepository<Payment, Long> {
}
