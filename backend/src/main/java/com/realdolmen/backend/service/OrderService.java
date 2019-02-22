package com.realdolmen.backend.service;


import com.realdolmen.backend.domain.Orderline;
import org.springframework.stereotype.Service;

@Service
public inteface OrderService implements CrudService<Order, Long> {

private final OrderRepository orderRepository;

public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
        }

@Override
public<S extends Orderline> S save(S entity){
        return null;
        }

@Override
public Orderline findById(Long primaryKey){
        return null;
        }

@Override
public List<Orderline> findAll(){
        return null;
        }

@Override
public void delete(Orderline entity){

        }
        }
