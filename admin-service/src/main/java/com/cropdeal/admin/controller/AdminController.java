package com.cropdeal.admin.controller;

import com.cropdeal.admin.dto.DealerDTO;
import com.cropdeal.admin.dto.FarmerDTO;
import com.cropdeal.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/farmers/{id}")
    public FarmerDTO getFarmer(@PathVariable Long id) {
        return adminService.getFarmerById(id);
    }

    @PutMapping("/farmer/{id}/status")
    public FarmerDTO changeFarmerStatus(@PathVariable Long id, @RequestParam boolean active) {
        return adminService.updateFarmerStatus(id, active);
    }

    @PutMapping("/farmer/{id}")
    public FarmerDTO updateFarmer(@PathVariable Long id, @RequestBody FarmerDTO farmerDTO) {
        return adminService.updateFarmer(id, farmerDTO);
    }

    @PutMapping("/dealer/{id}")
    public DealerDTO updateDealer(@PathVariable Long id, @RequestBody DealerDTO dealerDTO) {
        return adminService.updateDealer(id, dealerDTO);
    }

    @PutMapping("/dealer/{id}/status")
    public DealerDTO changeDealerStatus(@PathVariable Long id, @RequestParam boolean active) {
        return adminService.updateDealerStatus(id, active);
    }

    @GetMapping("/dealer/{id}")
    public DealerDTO getDealer(@PathVariable Long id) {
        return adminService.getDealerById(id);
    }

}
