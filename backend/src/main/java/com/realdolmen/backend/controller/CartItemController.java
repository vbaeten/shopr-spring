package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Cart;
import com.realdolmen.backend.domain.CartItem;
import com.realdolmen.backend.domain.Product;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.service.CartItemService;
import com.realdolmen.backend.service.CartService;
import com.realdolmen.backend.service.ProductService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@RestController
@SessionScope
public class CartItemController {

    private final CartService cartService;
    private final CartItemService cartItemService;
    private final ProductService productService;

    public CartItemController(CartService cartService, CartItemService cartItemService, ProductService productService) {
        this.cartService = cartService;
        this.cartItemService = cartItemService;
        this.productService = productService;
    }

    @RequestMapping("/cart/add/{productId}")
    public void addCartItem(@PathVariable(value = "productId") Long productId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Cart cart = user.getCart();
        List<CartItem> cartItems = cart.getCartItems();
        Product product = productService.findById(productId);
        for(CartItem cartItem : cartItems) {
            if(product.getId().equals(cartItem.getId())){
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setPrice(cartItem.getQuantity() * cartItem.getProduct().getPrice());
                cartItems.add(cartItem);
            }
        }
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(1);
        cartItem.setProduct(product);
        cartItem.setCart(cart);
        cartItemService.addItem(cartItem);
    }

    @RequestMapping("/cart/remove/{cartItemId}")
    public void removeItem(@PathVariable(value = "cartItemId") Long cartItemId) {
        cartItemService.removeItem(cartItemId);
    }

    @RequestMapping("cart/removeAll/{cartId}")
    public void removeAllItems(@PathVariable(value = "cartId") Long cartId) {
        Cart cart = cartService.getCartById(cartId);
        cartItemService.removeAll(cart);
    }
}
