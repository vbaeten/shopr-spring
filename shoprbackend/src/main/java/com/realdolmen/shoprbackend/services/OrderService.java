package com.realdolmen.shoprbackend.services;


import com.realdolmen.shoprbackend.domain.Order;
import com.realdolmen.shoprbackend.exception.NotFoundException;
import com.realdolmen.shoprbackend.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements CrudService<Order,Long> {


    private OrderRepository orderRepository;

    @Override
    public <S extends Order> S save(S entity) {
        return orderRepository.save(entity) ;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public void delete(Order entity) {

    }


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
