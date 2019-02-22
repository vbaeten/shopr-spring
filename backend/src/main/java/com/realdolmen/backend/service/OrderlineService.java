package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Orderline;
import com.realdolmen.backend.repositories.OrderlineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderlineService implements CrudService<Orderline, Long> {

    private final OrderlineRepository orderlineRepository;

    public OrderlineService(OrderlineRepository orderlineRepository) {
        this.orderlineRepository = orderlineRepository;
    }

    @Override
    public <S extends Orderline> S save(S entity) {
        return null;
    }

    @Override
    public Orderline findById(Long primaryKey) {
        return null;
    }

    @Override
    public List<Orderline> findAll() {
        return null;
    }

    @Override
    public void delete(Orderline entity) {

    }
}
