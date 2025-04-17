package com.cropdeal.admin.client;

import com.cropdeal.admin.dto.FarmerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "farmer-service")
public interface FarmerClient {

    @GetMapping("api/farmers/{id}")
    FarmerDTO getFarmerById(@PathVariable Long id);

    @PutMapping("/api/farmers/{id}")
    FarmerDTO updateFarmer(@PathVariable Long id, @RequestBody FarmerDTO farmerDTO);

    @PutMapping("/api/farmers/{id}/status")
    FarmerDTO updateFarmerStatus(@PathVariable Long id,@RequestParam Boolean active);
}
