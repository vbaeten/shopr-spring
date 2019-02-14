package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.service.OrderlineService;
import com.realdolmen.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private OrderlineService orderlineService;
    private UserService userService;

    public ShoppingCartController(OrderlineService orderlineService) {
        this.orderlineService = orderlineService;
    }

    @PostMapping("/add")
    public OrderLine addToCart(@RequestBody OrderLine orderLine) {
        orderlineService.save(orderLine);
        return orderLine;
    }

    @GetMapping("/{user}")
    public List<OrderLine> getOrderLinesByUser(@PathVariable("user") User user) {
        return orderlineService.findByUser(user);
    }

    @GetMapping("/list/{id}")
    public List<OrderLine> getOrderLinesByUserId(@PathVariable("id") Long id) {
        return orderlineService.findByUserId(id);
    }
}
