package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.dto.OrderLineDto;
import com.realdolmen.backend.facade.OrderLineFacade;
import com.realdolmen.backend.service.OrderLineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderline")
public class OrderLineController {

    private OrderLineService orderLineService;
    private OrderLineFacade orderLineFacade;

    public OrderLineController(OrderLineService orderLineService,
                               OrderLineFacade orderLineFacade) {
        this.orderLineService = orderLineService;
        this.orderLineFacade = orderLineFacade;
    }

    @PostMapping("/add")
    public OrderLineDto addToCart(@RequestBody OrderLineDto orderLineDto) {
        return orderLineFacade.createOrderLine(orderLineDto);
    }

    @GetMapping("/list/{id}")
    public List<OrderLine> findByUserId(@PathVariable("id") Long id) {
        return orderLineService.findByUserId(id);
    }

    @GetMapping("/current/{id}")
    public List<OrderLine> findCurrentCartByUserId(@PathVariable("id") Long id) {
        return orderLineService.findCurrentCartByUserId(id);
    }

    @DeleteMapping("/delete")
    public void deleteOrderLine(OrderLineDto orderLineDto) {
        orderLineFacade.deleteOrderLine(orderLineDto);
    }

}
