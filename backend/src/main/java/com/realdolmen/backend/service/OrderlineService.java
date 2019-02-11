package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.OrderLine;

import java.util.List;

public interface OrderlineService extends CrudService<OrderLine, Long> {

    @Override
    <S extends OrderLine> S save(S entity);

    @Override
    OrderLine findById(Long aLong);

    @Override
    List<OrderLine> findAll();

    @Override
    void delete(OrderLine entity);
}
