package com.cropdeal.admin.dto;


import lombok.Data;

@Data
public class FarmerDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private boolean active;

}
