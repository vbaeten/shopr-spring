package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Orderline;
import com.realdolmen.backend.dto.OrderlineDto;
import org.modelmapper.ModelMapper;

public class OrderlineMapper {

    private static ModelMapper modelMapper;

    private OrderlineMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static OrderlineDto convertOrderlineToDto(Orderline orderline) {
        return modelMapper.map(orderline, OrderlineDto.class);
    }
}
