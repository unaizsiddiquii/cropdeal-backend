package com.cropdeal.payment.service;

import com.cropdeal.payment.dto.PaymentRequest;
import com.cropdeal.payment.dto.PaymentResponse;

public interface PaymentService {
    PaymentResponse processPayment(PaymentRequest request);
}
