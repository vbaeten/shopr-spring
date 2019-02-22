package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.domain.ShoppingCart;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.service.OrderLineService;
import com.realdolmen.backend.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private OrderLineService orderlineService;
    private ShoppingCartService shoppingCartService;

    public ShoppingCartController(OrderLineService orderlineService,
                                  ShoppingCartService shoppingCartService) {
        this.orderlineService = orderlineService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/add")
    public OrderLine addToCart(@RequestBody OrderLine orderLine) {
        orderlineService.save(orderLine);
        return orderLine;
    }

    @PostMapping("/create")
    public ShoppingCart createCart(@RequestBody ShoppingCart shoppingCart) {
        shoppingCartService.save(shoppingCart);
        return shoppingCart;
    }

    @GetMapping("/{user}")
    public List<OrderLine> getOrderLinesByUser(@PathVariable("user") User user) {
        return orderlineService.findByUser(user);
    }

    @GetMapping("/cart/{id}")
    public ShoppingCart getCartByUserId(@PathVariable("id") Long id) {
        return shoppingCartService.findByUserId(id);
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
