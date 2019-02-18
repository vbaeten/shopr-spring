package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repository.OrderLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    private final OrderLineRepository orderLineRepository;

    public OrderLineServiceImpl(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public <S extends OrderLine> S save(S entity) {
        return orderLineRepository.save(entity);
    }

    @Override
    public OrderLine findById(Long id) {
        return orderLineRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<OrderLine> findAll() {
        return orderLineRepository.findAll();
    }

    @Override
    public List<OrderLine> findByUser(User user) {
        return orderLineRepository.findByUser(user);
    }

    @Override
    public List<OrderLine> findByUserId(Long id) {return orderLineRepository.findByUserId(id);}

    @Override
    public void delete(OrderLine entity) {
        orderLineRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        OrderLine orderLine = findById(id);
        orderLineRepository.delete(orderLine);
    }

    @Override
    public List<OrderLine> findCurrentCartByUserId(Long id) {
        return orderLineRepository.findCurrentCartByUserId(id);
    }

}
