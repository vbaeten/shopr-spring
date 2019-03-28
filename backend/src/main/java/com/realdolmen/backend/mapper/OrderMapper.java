package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    private final ModelMapper modelMapper;

    public OrderDto convertOrderToDto(Order order) {
        if (isNull(order)) {
            return null;
        }

        return modelMapper.map(order, OrderDto.class);
    }
}
