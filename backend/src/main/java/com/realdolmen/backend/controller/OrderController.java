package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/send")
    public Order sendToOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

    @GetMapping("/list/{id}")
    public List<Order> findByUserId(@PathVariable("id") Long id) {
        return orderService.findByUserId(id);
    }



}
