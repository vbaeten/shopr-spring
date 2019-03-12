package com.realdolmen.backend.controllers;

import com.realdolmen.backend.model.OrderFromShop;
import com.realdolmen.backend.model.OrderLine;
import com.realdolmen.backend.services.ArticleServiceImpl;
import com.realdolmen.backend.services.OrderFromShopServiceImpl;
import com.realdolmen.backend.services.OrderlineServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderlineController
{

    private OrderlineServiceImpl orderlineService;
    private ArticleServiceImpl articleService;
    private OrderFromShopServiceImpl orderFromShopService;


    public OrderlineController(OrderlineServiceImpl orderlineService, ArticleServiceImpl articleService, OrderFromShopServiceImpl orderFromShopService)
    {
        this.orderlineService = orderlineService;
        this.articleService = articleService;
        this.orderFromShopService = orderFromShopService;
    }

    @PostMapping(path = "/orderline")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderLine save(@RequestBody @Valid OrderLine orderLine)
    {
        return orderlineService.save(orderLine);


    }

    @PostMapping(path = "/createorder")
    public OrderFromShop save( OrderFromShop orderFromShop)
    {
        return orderFromShopService.save(orderFromShop);
    }

//    @PostMapping(path = "/order", consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)
//    public OrderFromShop edit(@RequestBody @Valid OrderFromShop order)
//    {
//        completeOrder = new OrderFromShop();
//        completeOrder = orderFromShopService.save(order);
//        return completeOrder;
//    }

}
