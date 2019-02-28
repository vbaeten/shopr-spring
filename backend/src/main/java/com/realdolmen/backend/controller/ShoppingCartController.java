package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.OrderLineDto;
import com.realdolmen.backend.facade.OrderLineFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private OrderLineFacade orderLineFacade;

    public ShoppingCartController(OrderLineFacade orderLineFacade) {
        this.orderLineFacade = orderLineFacade;
    }

    @PostMapping("/add")
    public OrderLineDto addToCart(@RequestBody OrderLineDto orderLineDto) {
        return orderLineFacade.createOrderLine(orderLineDto);
    }

    @GetMapping("/list/{id}")
    public List<OrderLineDto> getOrderLinesByUserId(@PathVariable("id") Long id) {
        return orderLineFacade.findByUserId(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderLineById(@PathVariable("id") Long id) {
        orderLineFacade.deleteById(id);
    }
}
