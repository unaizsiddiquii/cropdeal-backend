package com.cropdeal.payment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PaymentRequest {

    @NotBlank(message = "Buyers ID if required")
    private String buyerID;

    @NotBlank(message = "Crop ID is required")
    private String cropID;

    @NotNull(message = "Amount must not be null")
    @Positive(message = "Amount must be positive")
    private Double amount;

    @NotBlank(message = "Payment method required")
    private String paymentMethod;


}
