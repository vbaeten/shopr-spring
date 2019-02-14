package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.domain.User;

import java.util.List;

public interface OrderlineService extends CrudService<OrderLine, Long> {

    @Override
    <S extends OrderLine> S save(S entity);

    @Override
    OrderLine findById(Long aLong);

    @Override
    List<OrderLine> findAll();

    List<OrderLine> findByUser(User user);

    List<OrderLine> findByUserId(Long id);

    @Override
    void delete(OrderLine entity);
}
