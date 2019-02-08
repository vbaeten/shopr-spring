package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Cart;
import com.realdolmen.backend.service.CartService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

@RestController
@SessionScope
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/cart/{cartId}")
    @ResponseBody
    public Cart getCartItems(@PathVariable(value = "cartId") Long cartId) {
        return cartService.getCartById(cartId);
    }
}
