package com.cropdeal.farmer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmerDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String bankAccountNumber;
    private String ifscCode;
    private boolean active;
}
