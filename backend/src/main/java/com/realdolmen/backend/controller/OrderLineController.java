package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.service.OrderLineService;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete")
    public void deleteUser(OrderLine orderLine) {
        orderLineService.delete(orderLine);
    }

}
