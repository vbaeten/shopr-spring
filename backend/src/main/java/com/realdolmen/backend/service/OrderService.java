package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.domain.enums.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    Order findById(Long id);

    void deleteById(Long id);

    List<Order> findAll();

    List<Order> findAllByUser(User user);

    Order findByUserAndOrderStatus(User user, OrderStatus orderStatus);

    Order create(Order order);

    Order save(Order order);

    Order orderNow(Order order);
}
