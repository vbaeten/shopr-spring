package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.Domain.Order;
import com.realdolmen.backend.repositories.OrderRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/orders")
public class OrderRestController {
    private final OrderRepository orderRepository;

    public OrderRestController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PutMapping("/save")
    public Order save(@RequestBody @Valid Order order) {
        return orderRepository.save(order);
    }
}
