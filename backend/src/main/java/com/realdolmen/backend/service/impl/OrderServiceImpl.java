package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.domain.Orderline;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.domain.enums.OrderStatus;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repositories.OrderRepository;
import com.realdolmen.backend.repositories.OrderlineRepository;
import com.realdolmen.backend.repositories.UserRepository;
import com.realdolmen.backend.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderlineRepository orderlineRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderlineRepository orderlineRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.orderlineRepository = orderlineRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Order findById(Long id) {
        return this.orderRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public <S extends Order> S save(S entity) {
        return orderRepository.save(entity);
    }

    @Override
    public void saveOrderline(Order savedOrder, List<Orderline> persistedOrderlines, Orderline orderline) {
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

    @Override
    public List<Order> findAllByUser(User user) {
        return orderRepository.findAllByUser(user);
    }

    @Override
    public Optional<Order> findByUserAndOrderStatus(User user, OrderStatus orderStatus) {
        return orderRepository.findByUserAndOrderStatus(user, OrderStatus.IN_CART);
    }
}
