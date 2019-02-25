package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Cart;
import com.realdolmen.backend.service.CartItemService;
import com.realdolmen.backend.service.CartService;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    private final CartService cartService;
    private final CartItemService cartItemService;

    public CartController(CartService cartService, CartItemService cartItemService) {
        this.cartService = cartService;
        this.cartItemService = cartItemService;
    }

    @RequestMapping(value = "/cart/{cartId}")
    public Cart getCartItems(@PathVariable(value = "cartId") String cartId) throws NotFoundException {
        return cartService.getCartById(cartId);
    }

    @PostMapping(value = "/cart")
    public Cart saveCart(@RequestBody Cart cart) throws NotFoundException {

        return cartService.saveCart(cart);
    }
}
