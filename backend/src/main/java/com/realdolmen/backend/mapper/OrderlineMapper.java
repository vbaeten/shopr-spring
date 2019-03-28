package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Orderline;
import com.realdolmen.backend.dto.OrderlineDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderlineMapper {

    private final ModelMapper modelMapper;

    public OrderlineDto convertOrderlineToDto(Orderline orderline) {
        return modelMapper.map(orderline, OrderlineDto.class);
    }
}
