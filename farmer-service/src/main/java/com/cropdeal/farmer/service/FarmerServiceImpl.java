package com.cropdeal.farmer.service;

import com.cropdeal.farmer.entity.Farmer;
import com.cropdeal.farmer.exception.FarmerNotFoundException;
import com.cropdeal.farmer.exception.ResourceNotFoundException;
import com.cropdeal.farmer.dto.FarmerDTO;
import com.cropdeal.farmer.mapper.FarmerMapper;
import com.cropdeal.farmer.repository.FarmerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FarmerServiceImpl implements FarmerService {

    private final FarmerRepository farmerRepository;

    public FarmerServiceImpl(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }


    @Override
    public FarmerDTO createFarmer(FarmerDTO farmerDTO) {
        Farmer farmer = FarmerMapper.mapToFarmer(farmerDTO);
        Farmer saved = farmerRepository.save(farmer);
        return FarmerMapper.mapToFarmerDTO(saved);
    }

    @Override
    public FarmerDTO getFarmerById(Long id) {
        Farmer farmer = farmerRepository.findById(id).orElseThrow(() -> new FarmerNotFoundException("Farmer with ID " + id + " not found"));
        return FarmerMapper.mapToFarmerDTO(farmer);
    }

    @Override
    public List<FarmerDTO> getAllFarmers() {
        return farmerRepository.findAll().stream().map(FarmerMapper::mapToFarmerDTO).collect(Collectors.toList());
    }

    @Override
    public FarmerDTO updateFarmer(Long id, FarmerDTO farmerDTO) {
        Farmer farmer = farmerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not found with id: " + id));
        farmer.setName(farmerDTO.getName());
        farmer.setEmail(farmerDTO.getEmail());
        farmer.setPhone(farmerDTO.getPhone());
        farmer.setAddress(farmerDTO.getAddress());
        farmer.setBankAccountNumber(farmerDTO.getBankAccountNumber());
        farmer.setIfscCode(farmerDTO.getIfscCode());
        Farmer update = farmerRepository.save(farmer);
        return FarmerMapper.mapToFarmerDTO(update);
    }

    @Override
    public void deleteFarmer(Long id) {
        if (!farmerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Farmer not found with id: " + id);
        }
        farmerRepository.deleteById(id);

    }
}
