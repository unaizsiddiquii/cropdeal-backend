package com.cropdeal.dealer.service;

import com.cropdeal.dealer.dto.DealerDTO;
import com.cropdeal.dealer.entity.Dealer;
import com.cropdeal.dealer.exception.DealerNotFoundException;
import com.cropdeal.dealer.mapper.DealerMapper;
import com.cropdeal.dealer.repository.DealerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealerServiceImpl implements DealerService {

    private static final String ID_NOT_FOUND = "Dealer with ID %d not found";
    private final DealerRepository dealerRepository;


    @Override
    public DealerDTO createDealer(DealerDTO dealerDTO) {
        Dealer dealer = DealerMapper.mapToDealer(dealerDTO);
        Dealer savedDealer = dealerRepository.save(dealer);
        return DealerMapper.mapToDealerDTO(savedDealer);
    }

    @Override
    public List<DealerDTO> getAllDealers() {
        return dealerRepository.findAll()
                .stream()
                .map(DealerMapper::mapToDealerDTO).toList();
    }

    @Override
    public DealerDTO getDealerById(Long id) {

        Dealer dealer = dealerRepository.findById(id)
                .orElseThrow(() -> new DealerNotFoundException(String.format(ID_NOT_FOUND, id)));

        return DealerMapper.mapToDealerDTO(dealer);
    }

    @Override
    public DealerDTO updateDealer(Long id, DealerDTO dealerDTO) {
        Dealer dealer = dealerRepository.findById(id)
                .orElseThrow(() -> new DealerNotFoundException(String.format(ID_NOT_FOUND, id)));
        dealer.setDealerName(dealerDTO.getDealerName());
        dealer.setPhone(dealerDTO.getPhone());
        dealer.setEmail(dealerDTO.getEmail());
        dealer.setAddress(dealerDTO.getAddress());
        dealer.setActive(dealerDTO.isActive());
        Dealer updatedDealer = dealerRepository.save(dealer);
        return DealerMapper.mapToDealerDTO(updatedDealer);
    }

    @Override
    public void deleteDealer(Long id) {
        Dealer dealer = dealerRepository.findById(id).orElseThrow(() -> new DealerNotFoundException(String.format(ID_NOT_FOUND, id)));
        dealerRepository.delete(dealer);
    }

    @Override
    public DealerDTO updateDealerStatus(Long id, boolean active) {
        Dealer dealer = dealerRepository.findById(id).orElseThrow(() -> new DealerNotFoundException(String.format(ID_NOT_FOUND, id)));
        dealer.setActive(active);
        dealerRepository.save(dealer);
        return DealerMapper.mapToDealerDTO(dealer);

    }


}
