package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.domain.enums.OrderStatus;
import com.realdolmen.backend.dto.OrderDto;
import com.realdolmen.backend.mapper.OrderMapper;
import com.realdolmen.backend.service.OrderService;
import com.realdolmen.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/orders")
public class OrderRestController {
    private final OrderService orderService;
    private final UserService userService;
    private final OrderMapper orderMapper;

    public OrderRestController(OrderService orderService, UserService userService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.userService = userService;
        this.orderMapper = orderMapper;
    }

    @GetMapping("/findCurrentCartByUserId/{userId}")
    public OrderDto findCurrentCartByUserId(@PathVariable Long userId) {
        return orderMapper.convertOrderToDto(orderService.findByUserAndOrderStatus(userService.findById(userId), OrderStatus.IN_CART));
    }

    @GetMapping("/all/{userId}")
    public List<OrderDto> findOrdersByUserId(@PathVariable Long userId) {
        return orderService.findAllByUser(userService.findById(userId)).stream()
                .map(orderMapper::convertOrderToDto)
                .collect(Collectors.toList());
    }

    @PutMapping(path = "/ordernow")
    public OrderDto orderNow(@RequestBody @Valid Order order) {
        return orderMapper.convertOrderToDto(orderService.orderNow(order));
    }

    @PostMapping(path = "/save")
    public void saveOrder(@RequestBody @Valid Order order) {
        orderService.save(order);
    }

}
