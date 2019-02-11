package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.Domain.Orderline;
import com.realdolmen.backend.repositories.OrderlineRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderlines")
public class OrderlineRestController {
    private final OrderlineRepo orderlineRepo;

    public OrderlineRestController(OrderlineRepo orderlineRepo) {
        this.orderlineRepo = orderlineRepo;
    }

    @GetMapping(value = "/all")
    public List<Orderline> findAllOrderlines() {
        return orderlineRepo.findAll();
    }

    @PostMapping(value = "/add")
    public Orderline createOrderLine(@RequestBody Orderline orderline) {
        return orderlineRepo.save(orderline);
    }

}
