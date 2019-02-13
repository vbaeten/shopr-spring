package com.realdolmen.backend.controllers;

import com.realdolmen.backend.model.OrderLine;
import com.realdolmen.backend.model.User;
import com.realdolmen.backend.services.OrderlineServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderlineController
{

    private OrderlineServiceImpl orderlineService;

    public OrderlineController(OrderlineServiceImpl orderlineService)
    {
        this.orderlineService = orderlineService;
    }

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderLine save(@RequestBody @Valid OrderLine orderLine)
    {
        System.out.println("save orderline");
        return orderlineService.save(orderLine);
    }

}
