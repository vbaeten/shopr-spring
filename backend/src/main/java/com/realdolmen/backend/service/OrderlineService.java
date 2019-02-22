package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Orderline;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderlineService extends CrudService<Orderline, Long> {
    Orderline findById(Long id);

    List<Orderline> findAll();

    Orderline create(Orderline orderline);

    void deleteById(Long id);
}


