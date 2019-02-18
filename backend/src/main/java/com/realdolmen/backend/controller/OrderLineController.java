package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.service.OrderLineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orderline")
public class OrderLineController {

    private OrderLineService orderLineService;

    public OrderLineController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    @GetMapping("/list/{id}")
    public List<OrderLine> findByUserId(@PathVariable("id") Long id) {
        return orderLineService.findByUserId(id);
    }

    @GetMapping("/current/{id}")
    public List<OrderLine> findCurrentCartByUserId(@PathVariable("id") Long id) {
        return orderLineService.findCurrentCartByUserId(id);
    }


}
