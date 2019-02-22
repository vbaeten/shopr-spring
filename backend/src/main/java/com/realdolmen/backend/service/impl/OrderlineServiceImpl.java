package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.Orderline;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repositories.OrderlineRepository;
import com.realdolmen.backend.service.OrderlineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderlineServiceImpl implements OrderlineService {

    private final OrderlineRepository orderlineRepository;

    public OrderlineServiceImpl(OrderlineRepository orderlineRepository) {
        this.orderlineRepository = orderlineRepository;
    }

    @Override
    public Orderline findById(Long id) {
        return orderlineRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Orderline> findAll() {
        return orderlineRepository.findAll();
    }

    @Override
    public Orderline create(Orderline orderline) {
        return orderlineRepository.save(orderline);
    }

    @Override
    public void deleteById(Long id) {
        orderlineRepository.deleteById(id);
    }

    @Override
    public <S extends Orderline> S save(S entity) {
        return orderlineRepository.save(entity);
    }
}
