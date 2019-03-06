package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.OrderLineDto;
import com.realdolmen.backend.facade.OrderLineFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderline")
public class OrderLineController {

    private OrderLineFacade orderLineFacade;

    public OrderLineController(OrderLineFacade orderLineFacade) {
        this.orderLineFacade = orderLineFacade;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderLineDto addToCart(@RequestBody OrderLineDto orderLineDto) {
        return orderLineFacade.createOrderLine(orderLineDto);
    }

    @GetMapping("/list/{id}")
    public List<OrderLineDto> findByUserId(@PathVariable("id") Long id) {
        return orderLineFacade.findByUserId(id);
    }

    @GetMapping("/current/{id}")
    public List<OrderLineDto> findCurrentCartByUserId(@PathVariable("id") Long id) {
        return orderLineFacade.loadShoppingCart(id);
    }

    @DeleteMapping("/delete")
    public void deleteOrderLine(OrderLineDto orderLineDto) {
        orderLineFacade.deleteOrderLine(orderLineDto);
    }

}
