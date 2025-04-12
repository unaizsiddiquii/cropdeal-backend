package com.cropdeal.cropservice.controller;

import com.cropdeal.cropservice.dto.CropDTO;
import com.cropdeal.cropservice.service.CropService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
@RequiredArgsConstructor
public class CropController {

    private final CropService cropService;

    @PostMapping
    public ResponseEntity<CropDTO> createCrop(@Valid @RequestBody CropDTO cropDTO) {
        CropDTO dto = cropService.createCrop(cropDTO);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CropDTO>> getAllCrops() {
        return new ResponseEntity<>(cropService.getAllCrops(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CropDTO> getCropById(@PathVariable Long id) {
        return new ResponseEntity<>(cropService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CropDTO> updateCrops(@Valid @RequestBody CropDTO cropDTO, @PathVariable Long id) {
        return new ResponseEntity<>(cropService.updateCrops(id, cropDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCrop(@PathVariable Long id) {
        cropService.deleteCrop(id);
    }

    @GetMapping("name/{cropName}")
    public ResponseEntity<CropDTO> getByCropName(@PathVariable String cropName) {
        CropDTO cropDTO = cropService.getCropByName(cropName);

        return new ResponseEntity<>(cropDTO, HttpStatus.OK);
    }

}
