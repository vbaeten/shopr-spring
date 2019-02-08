package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Cart;
import com.realdolmen.backend.domain.CartItem;
import com.realdolmen.backend.repository.CartItemRepository;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public CartItem addItem(CartItem cartItem) {
        return cartItemRepository.saveAndFlush(cartItem);
    }

    public void removeItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public void removeAll(Cart cart) {
        cartItemRepository.deleteAllByCart(cart);
    }
}
