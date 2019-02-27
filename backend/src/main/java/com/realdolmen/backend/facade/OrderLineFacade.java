package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.dto.OrderLineDto;
import com.realdolmen.backend.mapper.OrderLineMapper;
import com.realdolmen.backend.service.OrderLineService;
import org.springframework.stereotype.Component;

@Component
public class OrderLineFacade {

    private final OrderLineService orderLineService;
    private final OrderLineMapper orderLineMapper;

    public OrderLineFacade(OrderLineService orderLineService, OrderLineMapper orderLineMapper) {
        this.orderLineService = orderLineService;
        this.orderLineMapper = orderLineMapper;
    }

    public OrderLineDto createOrderLine(OrderLineDto orderLineDto) {
        OrderLine orderLine = orderLineMapper.OrderLineDtoToOrderLine(orderLineDto);
        OrderLine savedOrderLine = orderLineService.save(orderLine);
        return orderLineMapper.OrderLineToOrderLineDto(savedOrderLine);
    }

    public void deleteOrderLine(OrderLineDto orderLineDto) {
        OrderLine orderLine = orderLineMapper.OrderLineDtoToOrderLine(orderLineDto);
        orderLineService.delete(orderLine);
    }
}
