package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Cart;
import com.realdolmen.backend.repository.CartRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCartById(String id) throws NotFoundException {
        return cartRepository.findById(id).orElseThrow(() -> new NotFoundException("cart not found"));
    }

    public Cart saveCart(Cart cart) throws NotFoundException {
        return cartRepository.saveAndFlush(cart);
    }
}
