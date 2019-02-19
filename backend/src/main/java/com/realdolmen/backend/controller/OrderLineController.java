package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.service.OrderLineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/orderLine")
public class OrderLineController {

    private OrderLineService orderLineService;

    @PostMapping
    public OrderLine save(@RequestBody OrderLine orderLine) {
        return orderLineService.save(orderLine);
    }

    @GetMapping("/{id}")
    public OrderLine findById(@PathVariable Long id) {
        return orderLineService.findById(id);
    }

    @GetMapping
    public List<OrderLine> findAll() {
        return orderLineService.findAll();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        orderLineService.deleteById(id);
    }

}
