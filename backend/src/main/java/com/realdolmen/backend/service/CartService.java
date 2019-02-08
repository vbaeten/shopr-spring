package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Cart;
import com.realdolmen.backend.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
