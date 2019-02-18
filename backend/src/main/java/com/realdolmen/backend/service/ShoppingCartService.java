package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.ShoppingCart;

import java.util.List;


public interface ShoppingCartService extends CrudService<ShoppingCart, Long> {

    ShoppingCart findByUserId(Long userId);
}
