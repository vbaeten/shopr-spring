package com.realdolmen.shoprbackend.services;


import com.realdolmen.shoprbackend.domain.OrderLine;
import com.realdolmen.shoprbackend.exception.NotFoundException;
import com.realdolmen.shoprbackend.repository.OrderLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService implements CrudService<OrderLine,Long> {


    private OrderLineRepository orderLineRepository;


    @Override
    public <S extends OrderLine> S save(S entity) {
        return orderLineRepository.save(entity);
    }

    @Override
    public OrderLine findById(Long id) {
        return orderLineRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<OrderLine> findAll() {
        return orderLineRepository.findAll();
    }

    @Override
    public void delete(OrderLine entity) {

    }

    public OrderLineService(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    public void deleteById(Long id) {
        OrderLine orderLine = findById(id);
        this.orderLineRepository.delete(orderLine);
    }
}
