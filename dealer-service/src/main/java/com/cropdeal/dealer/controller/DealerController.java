package com.cropdeal.dealer.controller;

import com.cropdeal.dealer.dto.DealerDTO;
import com.cropdeal.dealer.service.DealerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dealers")
@RequiredArgsConstructor
public class DealerController {

    private final DealerService dealerService;

    @PostMapping
    public ResponseEntity<DealerDTO> createdDealer(@Valid @RequestBody DealerDTO dealerDTO) {
        DealerDTO savedDealer = dealerService.createDealer(dealerDTO);
        return new ResponseEntity<>(savedDealer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DealerDTO>> getAllDealers() {
        return new ResponseEntity<>(dealerService.getAllDealers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DealerDTO> getDealerById(@PathVariable Long id) {
        DealerDTO dealerDTO = dealerService.getDealerById(id);
        return new ResponseEntity<>(dealerDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DealerDTO> updateDealer(@Valid @RequestBody DealerDTO dealerDTO, @PathVariable Long id) {
        DealerDTO updatedDealer = dealerService.updateDealer(id, dealerDTO);
        return new ResponseEntity<>(updatedDealer, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDealer(@PathVariable Long id) {
        dealerService.deleteDealer(id);
        return ResponseEntity.noContent().build();
    }


}
