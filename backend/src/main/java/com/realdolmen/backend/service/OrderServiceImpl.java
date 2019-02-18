package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public <S extends Order> S save(S entity) {
        entity.getOrderLines().forEach(orderLine -> orderLine.setOrder(entity));
        return orderRepository.save(entity);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void delete(Order entity) {

    }

    @Override
    public List<Order> findByUserId(Long id) {
        return orderRepository.findOrdersByUserId(id);
    }
}
