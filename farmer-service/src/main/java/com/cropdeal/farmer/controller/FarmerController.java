package com.cropdeal.farmer.controller;

import com.cropdeal.farmer.dto.FarmerDTO;
import com.cropdeal.farmer.service.FarmerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
@RequiredArgsConstructor
public class FarmerController {
    private final FarmerService farmerService;

    @PostMapping
    public ResponseEntity<FarmerDTO> addFarmer(@RequestBody FarmerDTO farmerDTO) {
        FarmerDTO created = farmerService.createFarmer(farmerDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmerDTO> getFarmerById(@PathVariable Long id) {
        return farmerService.getFarmerById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<FarmerDTO>> getAllFarmers() {
        List<FarmerDTO> farmers = farmerService.getAllFarmers();
        return ResponseEntity.ok(farmers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FarmerDTO> updateFarmer(@PathVariable Long id, @RequestBody FarmerDTO farmerDTO) {
        FarmerDTO updated = farmerService.updateFarmer(id, farmerDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarmer(@PathVariable Long id) {
        farmerService.deleteFarmer(id);
        return ResponseEntity.noContent().build();
    }
}
