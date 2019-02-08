package com.realdolmen.shoprbackend.controller;


import com.realdolmen.shoprbackend.domain.Order;
import com.realdolmen.shoprbackend.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {


    private OrderService orderService;


    @PostMapping
    public Order saveOrderLine(@RequestBody Order order){
        orderService.save(order);
        return order;
    }




    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
}
