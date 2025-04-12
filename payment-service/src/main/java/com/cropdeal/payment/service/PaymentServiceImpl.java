package com.cropdeal.payment.service;

import com.cropdeal.payment.dto.PaymentRequest;
import com.cropdeal.payment.dto.PaymentResponse;
import com.cropdeal.payment.entity.Payment;
import com.cropdeal.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;


    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        String transactionID = UUID.randomUUID().toString();
        Payment payment = Payment.builder()
                .transactionId(transactionID)
                .buyerId(request.getBuyerID())
                .cropId(request.getCropID())
                .amount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .status("SUCCESS")
                .paymentTime(LocalDateTime.now())
                .build();

        paymentRepository.save(payment);
        return new PaymentResponse(transactionID, "SUCCESS", "Payment processed successfully");

    }
}
