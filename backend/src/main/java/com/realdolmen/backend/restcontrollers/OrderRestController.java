package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.Domain.Order;
import com.realdolmen.backend.Domain.User;
import com.realdolmen.backend.Domain.enums.OrderStatus;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repositories.OrderRepository;
import com.realdolmen.backend.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/orders")
public class OrderRestController {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderRestController(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @PutMapping("/save")
    public Order save(@RequestBody @Valid Order order) {
        return orderRepository.save(order);
    }

    @GetMapping("/findCurrentCartByUserId/{userId}")
    public Order findCurrentCartByUserId(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(NotFoundException::new);
        return orderRepository.findByUserAndOrderStatus(user, OrderStatus.IN_CART)
                .orElse(null);
    }
}
