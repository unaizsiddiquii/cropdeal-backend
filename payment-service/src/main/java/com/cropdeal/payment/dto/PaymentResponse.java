package com.cropdeal.payment.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentResponse {
    private String transactionID;
    private String status;
    private String message;
}
