package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.dto.OrderLineDto;
import com.realdolmen.backend.mapper.OrderLineMapper;
import com.realdolmen.backend.service.OrderLineService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<OrderLineDto> loadShoppingCart(Long id) {
        List<OrderLine> orderLines = orderLineService.findCurrentCartByUserId(id);
        return orderLines.stream().map(orderLineMapper::OrderLineToOrderLineDto).collect(Collectors.toList());
    }

    public List<OrderLineDto> findByUserId(Long id) {
        List<OrderLine> orderLines = orderLineService.findByUserId(id);
        return orderLines.stream().map(orderLineMapper::OrderLineToOrderLineDto).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        orderLineService.deleteById(id);
    }
}
