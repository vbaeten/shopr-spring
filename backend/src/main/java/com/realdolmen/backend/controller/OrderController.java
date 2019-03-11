package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/order")
public class OrderController {

    private OrderService orderService;

    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) throws NotFoundException {
        return orderService.findById(id);
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
    }

}
