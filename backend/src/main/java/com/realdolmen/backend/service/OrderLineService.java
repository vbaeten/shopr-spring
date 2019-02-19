package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.OrderLine;

import java.util.List;

public interface OrderLineService extends CrudService<OrderLine, Long>{
    void deleteById(Long id);

    List<OrderLine> findByOrderId(Long orderId);
}
