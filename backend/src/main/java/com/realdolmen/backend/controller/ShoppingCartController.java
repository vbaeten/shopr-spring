package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.service.OrderlineService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private OrderlineService orderlineService;

    public ShoppingCartController(OrderlineService orderlineService) {
        this.orderlineService = orderlineService;
    }

    @PostMapping("/add")
    public OrderLine addToCart(@RequestBody OrderLine orderLine) {
        orderlineService.save(orderLine);
        return orderLine;
    }
}
