package com.cropdeal.dealer.mapper;

import com.cropdeal.dealer.dto.DealerDTO;
import com.cropdeal.dealer.entity.Dealer;

public class DealerMapper {
    public static DealerDTO mapToDealerDTO(Dealer dealer) {
        return DealerDTO.builder().id(dealer.getId())
                .dealerName(dealer.getDealerName())
                .email(dealer.getEmail())
                .phone(dealer.getPhone())
                .active(dealer.isActive())
                .address(dealer.getAddress()).build();
    }

    public static Dealer mapToDealer(DealerDTO dto) {
        return Dealer.builder().id(dto.getId())
                .dealerName(dto.getDealerName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .active(dto.isActive())
                .address(dto.getAddress()).build();
    }
}
