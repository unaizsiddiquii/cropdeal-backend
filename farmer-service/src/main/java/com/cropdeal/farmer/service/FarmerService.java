package com.cropdeal.farmer.service;

import com.cropdeal.farmer.dto.FarmerDTO;

import java.util.List;
import java.util.Optional;


public interface FarmerService {
    FarmerDTO createFarmer(FarmerDTO farmerDTO);

    Optional<FarmerDTO> getFarmerById(Long id);

    List<FarmerDTO> getAllFarmers();

    FarmerDTO updateFarmer(Long id, FarmerDTO farmerDTO);


    void deleteFarmer(Long id);

}
