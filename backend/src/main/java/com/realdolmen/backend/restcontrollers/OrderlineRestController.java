package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.Orderline;
import com.realdolmen.backend.dto.OrderlineDto;
import com.realdolmen.backend.mapper.OrderlineMapper;
import com.realdolmen.backend.service.OrderlineService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orderlines")
public class OrderlineRestController {
    private final OrderlineService orderlineService;
    private final OrderlineMapper orderlineMapper;

    public OrderlineRestController(OrderlineService orderlineService, OrderlineMapper orderlineMapper) {
        this.orderlineService = orderlineService;
        this.orderlineMapper = orderlineMapper;
    }

    @GetMapping(value = "/all")
    public List<OrderlineDto> findAllOrderlines() {
        return orderlineService.findAll().stream()
                .map(orderlineMapper::convertOrderlineToDto)
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/add")
    public OrderlineDto createOrderLine(@RequestBody @Valid Orderline orderline) {
        return orderlineMapper.convertOrderlineToDto(orderlineService.save(orderline));
    }

    @GetMapping(value = "/{orderlineId}")
    public OrderlineDto getOrderline(@PathVariable Long orderlineId) {
        return orderlineMapper.convertOrderlineToDto(orderlineService.findById(orderlineId));
    }

    @DeleteMapping("/{orderlineId}")
    public void deleteById(@PathVariable("orderlineId") Long orderlineId) {
        orderlineService.deleteById(orderlineId);
    }

}
