package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.dto.OrderDto;
import org.modelmapper.ModelMapper;

public class OrderMapper {
    private static ModelMapper modelMapper;

    private OrderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static OrderDto convertOrderToDto(Order order) {
        return modelMapper.map(order, OrderDto.class);
    }
}
