package com.cropdeal.cropservice.mapper;

import com.cropdeal.cropservice.dto.CropDTO;
import com.cropdeal.cropservice.entity.Crop;

public class CropMapper {


    public static CropDTO mapToDTO(Crop crop) {
        return CropDTO.builder()
                .id(crop.getId())
                .cropName(crop.getCropName())
                .cropType(crop.getCropType())
                .pricePerKg(crop.getPricePerKg())
                .quantity(crop.getQuantity())
                .location(crop.getLocation())
                .farmerId(crop.getFarmerId())
                .build();
    }

    public static Crop mapToCrop(CropDTO dto) {
        return Crop.builder()
                .id(dto.getId())
                .cropType(dto.getCropType())
                .cropName(dto.getCropName())
                .pricePerKg(dto.getPricePerKg())
                .location(dto.getLocation())
                .quantity(dto.getQuantity())
                .farmerId(dto.getFarmerId())
                .build();
    }
}
