package com.cropdeal.farmer.service;

import com.cropdeal.farmer.dto.FarmerDTO;

import java.util.List;


public interface FarmerService {
    FarmerDTO createFarmer(FarmerDTO farmerDTO);

    FarmerDTO getFarmerById(Long id);

    List<FarmerDTO> getAllFarmers();

    FarmerDTO updateFarmer(Long id, FarmerDTO farmerDTO);

    void deleteFarmer(Long id);

    FarmerDTO updateFarmerStatus(Long id, boolean active);

}
