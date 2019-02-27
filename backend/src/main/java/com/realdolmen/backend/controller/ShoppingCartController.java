package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.OrderLineDto;
import com.realdolmen.backend.facade.OrderLineFacade;
import com.realdolmen.backend.service.OrderLineService;
import com.realdolmen.backend.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private OrderLineService orderlineService;
    private OrderLineFacade orderLineFacade;
    private ShoppingCartService shoppingCartService;

    public ShoppingCartController(OrderLineService orderlineService, OrderLineFacade orderLineFacade, ShoppingCartService shoppingCartService) {
        this.orderlineService = orderlineService;
        this.orderLineFacade = orderLineFacade;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/add")
    public OrderLineDto addToCart(@RequestBody OrderLineDto orderLineDto) {
        return orderLineFacade.createOrderLine(orderLineDto);
    }

    @GetMapping("/{user}")
    public List<OrderLine> getOrderLinesByUser(@PathVariable("user") User user) {
        return orderlineService.findByUser(user);
    }

    @GetMapping("/list/{id}")
    public List<OrderLine> getOrderLinesByUserId(@PathVariable("id") Long id) {
        return orderlineService.findByUserId(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderLineById(@PathVariable("id") Long id) {
        orderlineService.deleteById(id);
    }
}
