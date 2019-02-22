package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.Orderline;
import com.realdolmen.backend.repositories.OrderlineRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orderlines")
public class OrderlineRestController {
    private final OrderlineRepository orderlineRepository;

    public OrderlineRestController(OrderlineRepository orderlineRepository) {
        this.orderlineRepository = orderlineRepository;
    }

    @GetMapping(value = "/all")
    public List<Orderline> findAllOrderlines() {
        return orderlineRepository.findAll();
    }

    @PostMapping(value = "/add")
    public Orderline createOrderLine(@RequestBody @Valid Orderline orderline) {
        return orderlineRepository.save(orderline);
    }

    @GetMapping(value = "/{orderlineId}")
    public Orderline getOrderline(@PathVariable Long orderlineId) {
        return orderlineRepository.getOne(orderlineId);
    }

    @DeleteMapping("/{orderlineId}")
    public void deleteById(@PathVariable("orderlineId") Long orderlineId) {
        Orderline orderline = getOrderline(orderlineId);
        orderlineRepository.delete(orderline);
    }

}
