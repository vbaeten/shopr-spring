package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.OrderDto;
import com.realdolmen.backend.facade.OrderFacade;
import com.realdolmen.backend.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;
    private OrderFacade orderFacade;

    public OrderController(OrderService orderService, OrderFacade orderFacade) {
        this.orderService = orderService;
        this.orderFacade = orderFacade;
    }

    @PostMapping("/send")
    public OrderDto sendToOrder(@RequestBody OrderDto orderDto) {
        return orderFacade.save(orderDto);
    }

//    @GetMapping("/list/{id}")
//    public List<Order> findByUserId(@PathVariable("id") Long id) {
//        return orderService.findByUserId(id);
//    }

    @GetMapping("/list/{id}")
    public List<OrderDto> findByUserId(@PathVariable("id") Long id) {
        return orderFacade.findOrdersByUser(id);
    }
}
