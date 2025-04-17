package com.cropdeal.admin.client;

import com.cropdeal.admin.dto.DealerDTO;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.*;

@FeignClient(name = "dealer-service")
public interface DealerClient {

    @GetMapping("/api/dealers/{id}")
    public DealerDTO getDealerById(@PathVariable Long id);

    @PutMapping("/api/dealers/{id}/status")
    public DealerDTO updateDealerStatus(@PathVariable Long id, @RequestParam boolean active);

    @PutMapping("/api/dealers/{id}")
    public DealerDTO updateDealer(@RequestBody DealerDTO dealerDTO, @PathVariable Long id);


}
