package com.cropdeal.dealer.service;

import com.cropdeal.dealer.dto.DealerDTO;


import java.util.List;


public interface DealerService {

    DealerDTO createDealer(DealerDTO dealerDTO);

    List<DealerDTO> getAllDealers();

    DealerDTO getDealerById(Long id);

    DealerDTO updateDealer(Long id, DealerDTO dealerDTO);

    void deleteDealer(Long id);

    DealerDTO updateDealerStatus(Long id, boolean active);


}
