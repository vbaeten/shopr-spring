package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.repository.OrderLineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {

    private OrderLineRepository orderLineRepository;

    @Override
    public OrderLine save(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
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
    public void delete(OrderLine orderLine) {
        orderLineRepository.delete(orderLine);
    }

    @Override
    public void deleteById(Long id) {
        orderLineRepository.deleteById(id);
    }
}
