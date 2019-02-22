package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.domain.Orderline;
import com.realdolmen.backend.domain.enums.OrderStatus;
import com.realdolmen.backend.service.OrderService;
import com.realdolmen.backend.service.OrderlineService;
import com.realdolmen.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderRestController {
    private final OrderService orderService;
    private final OrderlineService orderlineService;
    private final UserService userService;

    public OrderRestController(OrderService orderService, OrderlineService orderlineService, UserService userService) {
        this.orderService = orderService;
        this.orderlineService = orderlineService;
        this.userService = userService;
    }

    @PutMapping("/save")
    @Transactional
    public Order save(@RequestBody @Valid Order order) {
        Order savedOrder = orderService.save(order);
        List<Orderline> persistedOrderlines = new ArrayList<>();
        order.getOrderlineList().forEach(orderline -> orderService.saveOrderline(savedOrder, persistedOrderlines, orderline));
        savedOrder.setOrderlineList(persistedOrderlines);
        return savedOrder;
    }

    @GetMapping("/findCurrentCartByUserId/{userId}")
    public Order findCurrentCartByUserId(@PathVariable Long userId) {
        return orderService.findByUserAndOrderStatus(userService.findById(userId), OrderStatus.IN_CART)
                .orElse(null);
    }

    @GetMapping("/all/{userId}")
    public List<Order> findOrdersByUserId(@PathVariable Long userId) {
        return orderService.findAllByUser(userService.findById(userId));
    }

    @PutMapping(path = "/ordernow")
    public void orderNow(@RequestBody @Valid Order order) {
        Order orderThis = findCurrentCartByUserId(order.getUser().getUserId());
        orderThis.setOrderStatus(OrderStatus.ORDERED);
        save(orderThis);
    }

}
