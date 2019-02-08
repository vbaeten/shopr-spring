package com.realdolmen.shoprbackend.controller;

import com.realdolmen.shoprbackend.domain.OrderLine;
import com.realdolmen.shoprbackend.services.OrderLineService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderLines")
public class OrderLineController {


   private OrderLineService orderLineService;

    @PostMapping
    public OrderLine saveOrderLine(@RequestBody OrderLine orderLine){
        orderLineService.save(orderLine);
        return orderLine;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderLine> findAll(){
        return orderLineService.findAll();
    }


    public OrderLineController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }
}
