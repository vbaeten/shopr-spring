package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repository.OrderLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderlineServiceImpl implements OrderlineService {

    private final OrderLineRepository orderLineRepository;

    public OrderlineServiceImpl(OrderLineRepository orderLineRepository) {
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
    public void delete(OrderLine entity) {
        orderLineRepository.delete(entity);
    }
}
