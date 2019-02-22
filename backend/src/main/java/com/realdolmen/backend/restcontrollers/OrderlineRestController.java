package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.Orderline;
import com.realdolmen.backend.service.OrderlineService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orderlines")
public class OrderlineRestController {
    private final OrderlineService orderlineService;

    public OrderlineRestController(OrderlineService orderlineService) {
        this.orderlineService = orderlineService;
    }

    @GetMapping(value = "/all")
    public List<Orderline> findAllOrderlines() {
        return orderlineService.findAll();
    }

    @PostMapping(value = "/add")
    public Orderline createOrderLine(@RequestBody @Valid Orderline orderline) {
        return orderlineService.save(orderline);
    }

    @GetMapping(value = "/{orderlineId}")
    public Orderline getOrderline(@PathVariable Long orderlineId) {
        return orderlineService.findById(orderlineId);
    }

    @DeleteMapping("/{orderlineId}")
    public void deleteById(@PathVariable("orderlineId") Long orderlineId) {
        orderlineService.deleteById(orderlineId);
    }

}
