package com.cropdeal.admin.service;

import com.cropdeal.admin.dto.DealerDTO;
import com.cropdeal.admin.dto.FarmerDTO;

public interface AdminService {

    FarmerDTO getFarmerById(Long id);

    FarmerDTO updateFarmer(Long id, FarmerDTO farmerDTO);

    FarmerDTO updateFarmerStatus(Long id, boolean active);

    DealerDTO getDealerById(Long id);

    DealerDTO updateDealerStatus(Long id, boolean active);

    DealerDTO updateDealer(Long id, DealerDTO dealerDTO);
}
