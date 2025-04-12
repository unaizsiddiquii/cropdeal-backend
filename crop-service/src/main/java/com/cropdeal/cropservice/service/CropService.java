package com.cropdeal.cropservice.service;

import com.cropdeal.cropservice.dto.CropDTO;

import java.util.List;

public interface CropService {

    CropDTO createCrop(CropDTO cropDTO);

    List<CropDTO> getAllCrops();

    CropDTO getById(Long id);

    CropDTO updateCrops(Long id, CropDTO cropDTO);

    void deleteCrop(Long id);

    public CropDTO getCropByName(String cropName);

}
