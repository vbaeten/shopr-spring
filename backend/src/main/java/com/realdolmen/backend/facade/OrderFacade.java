package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.dto.OrderDto;
import com.realdolmen.backend.mapper.OrderMapper;
import com.realdolmen.backend.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class OrderFacade {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderFacade(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    public OrderDto save(OrderDto orderDto) {
        Order order = orderMapper.OrderDtoToOrder(orderDto);
        Order createdOrder = orderService.save(order);
        return orderMapper.orderToOrderDto(createdOrder);
    }
}
