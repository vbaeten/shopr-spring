package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.Domain.Order;
import com.realdolmen.backend.Domain.Orderline;
import com.realdolmen.backend.Domain.User;
import com.realdolmen.backend.Domain.enums.OrderStatus;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repositories.OrderRepository;
import com.realdolmen.backend.repositories.OrderlineRepository;
import com.realdolmen.backend.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping(path = "/orders")
public class OrderRestController {
    private final OrderRepository orderRepository;
    private final OrderlineRepository orderlineRepository;
    private final UserRepository userRepository;

    public OrderRestController(OrderRepository orderRepository, OrderlineRepository orderlineRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.orderlineRepository = orderlineRepository;
        this.userRepository = userRepository;
    }

    @PutMapping("/save")
    @Transactional
    public Order save(@RequestBody @Valid Order order) {
        Order savedOrder = orderRepository.save(order);
        List<Orderline> persistedOrderlines = new ArrayList<>();
        order.getOrderlineList().forEach(orderline -> saveOrderline(savedOrder, persistedOrderlines, orderline));
        savedOrder.setOrderlineList(persistedOrderlines);
        return savedOrder;
    }

    private void saveOrderline(Order savedOrder, List<Orderline> persistedOrderlines, Orderline orderline) {
        if (nonNull(orderline.getOrderlineId())) {
            Orderline tempOrderline = orderlineRepository.findById(orderline.getOrderlineId())
                    .orElseThrow(RuntimeException::new);
            tempOrderline.setQuantity(orderline.getQuantity());
            tempOrderline.setSubTotal(orderline.getSubTotal());
            tempOrderline = orderlineRepository.save(tempOrderline);
            persistedOrderlines.add(tempOrderline);
        } else {
            orderline.setOrder(savedOrder);
            Orderline savedOrderline = orderlineRepository.save(orderline);
            persistedOrderlines.add(savedOrderline);
        }
    }

    @GetMapping("/findCurrentCartByUserId/{userId}")
    public Order findCurrentCartByUserId(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(NotFoundException::new);
        return orderRepository.findByUserAndOrderStatus(user, OrderStatus.IN_CART)
                .orElse(null);
    }
}
