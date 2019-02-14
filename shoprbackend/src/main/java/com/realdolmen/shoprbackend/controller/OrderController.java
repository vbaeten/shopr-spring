package com.realdolmen.shoprbackend.controller;


import com.realdolmen.shoprbackend.domain.Order;
import com.realdolmen.shoprbackend.services.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {


    private OrderService orderService;


    @PostMapping
    public Order saveOrder(@RequestBody Order order){
        orderService.save(order);
        return order;
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id){
        return orderService.findById(id);
    }




    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
}
