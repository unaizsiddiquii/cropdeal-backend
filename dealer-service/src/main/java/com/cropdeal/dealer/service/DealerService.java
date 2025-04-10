package com.cropdeal.dealer.service;

import com.cropdeal.dealer.dto.DealerDTO;
import com.cropdeal.dealer.repository.DealerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DealerService {

    DealerDTO createDealer(DealerDTO dealerDTO);

    List<DealerDTO> getAllDealers();

    DealerDTO getDealerById(Long id);

    DealerDTO updateDealer(Long id, DealerDTO dealerDTO);

    void deleteDealer(Long id);


}
