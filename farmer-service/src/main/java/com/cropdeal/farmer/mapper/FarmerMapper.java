package com.cropdeal.farmer.mapper;

import com.cropdeal.farmer.entity.Farmer;
import com.cropdeal.farmer.dto.FarmerDTO;

public class FarmerMapper {
    public static FarmerDTO mapToFarmerDTO(Farmer farmer) {
        return FarmerDTO.builder()
                .id(farmer.getId())
                .name(farmer.getName())
                .email(farmer.getEmail())
                .phone(farmer.getPhone())
                .address(farmer.getAddress())
                .bankAccountNumber(farmer.getBankAccountNumber())
                .ifscCode(farmer.getIfscCode())
                .build();
    }

    public static Farmer mapToFarmer(FarmerDTO dto) {
        return Farmer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .bankAccountNumber(dto.getBankAccountNumber())
                .ifscCode(dto.getIfscCode())
                .build();
    }
}
