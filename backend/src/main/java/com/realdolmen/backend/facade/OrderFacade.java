package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.dto.OrderDto;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.mapper.OrderMapper;
import com.realdolmen.backend.mapper.UserMapper;
import com.realdolmen.backend.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderFacade {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderFacade(OrderService orderService, OrderMapper orderMapper, UserMapper userMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    public List<OrderDto> findOrdersByUser(Long id) {
        List<Order> orders = orderService.findByUserId(id);
        return orders.stream().map(orderMapper::orderToOrderDto).collect(Collectors.toList());
    }

    public OrderDto save(OrderDto orderDto, UserDto userDto) {
        Order order = orderMapper.orderDtoToOrder(orderDto);
        Order createdOrder = orderService.save(order);
        return orderMapper.orderToOrderDto(createdOrder);
    }
}
