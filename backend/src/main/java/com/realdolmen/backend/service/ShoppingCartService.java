package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.ShoppingCart;

public interface ShoppingCartService extends CrudService<ShoppingCart, Long> {

    ShoppingCart findByUserId(Long userId);
}
