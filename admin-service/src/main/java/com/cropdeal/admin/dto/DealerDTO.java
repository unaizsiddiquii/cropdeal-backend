package com.cropdeal.admin.dto;

import lombok.Data;

@Data
public class DealerDTO {
    private String id;
    private String dealerName;
    private String email;
    private String phone;
    private String address;
    private boolean active;

}
