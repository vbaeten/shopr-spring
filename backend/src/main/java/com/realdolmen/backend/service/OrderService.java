package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Order;

import java.util.List;

public interface OrderService extends CrudService<Order, Long> {

    List<Order> findByUserId(Long id);
}
