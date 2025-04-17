package com.cropdeal.admin.service;

import com.cropdeal.admin.client.DealerClient;
import com.cropdeal.admin.client.FarmerClient;
import com.cropdeal.admin.dto.DealerDTO;
import com.cropdeal.admin.dto.FarmerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final FarmerClient farmerClient;
    private final DealerClient dealerClient;

    @Override
    public FarmerDTO getFarmerById(Long id) {
        return farmerClient.getFarmerById(id);
    }

    @Override
    public FarmerDTO updateFarmer(Long id, FarmerDTO farmerDTO) {
        return farmerClient.updateFarmer(id, farmerDTO);
    }

    @Override
    public FarmerDTO updateFarmerStatus(Long id, boolean active) {
        return farmerClient.updateFarmerStatus(id, active);
    }

    @Override
    public DealerDTO getDealerById(Long id) {
        return dealerClient.getDealerById(id);
    }

    @Override
    public DealerDTO updateDealerStatus(Long id, boolean active) {
        return dealerClient.updateDealerStatus(id, active);
    }

    @Override
    public DealerDTO updateDealer(Long id, DealerDTO dealerDTO) {
        return dealerClient.updateDealer(dealerDTO, id);
    }
}
