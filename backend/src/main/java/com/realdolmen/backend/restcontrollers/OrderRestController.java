package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.domain.enums.OrderStatus;
import com.realdolmen.backend.service.OrderService;
import com.realdolmen.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderRestController {
    private final OrderService orderService;
    private final UserService userService;

    public OrderRestController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
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
        orderService.save(orderThis);
    }

    @PutMapping(path = "/save")
    public void saveOrder(@RequestBody @Valid Order order) {
        orderService.save(order);
    }

}
