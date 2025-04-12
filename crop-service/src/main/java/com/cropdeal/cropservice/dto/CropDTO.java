package com.cropdeal.cropservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CropDTO {

    private Long id;

    @NotBlank(message = "Crop name is required")
    private String cropName;

    @NotBlank(message = "Crop Type is required")
    private String cropType;


    @NotNull(message = "Price must not be null")
    @Positive(message = "Price must be Positive")
    private Double pricePerKg;


    @NotNull(message = "Quantity must not be null")
    @Positive(message = "Quantity must be positive")
    private Double quantity;

    @NotBlank(message = "Location is required")
    @Size(min = 3, max = 50)
    private String location;


    @NotBlank(message = "Farmer ID is required")
    private String farmerId;
}

