package com.realdolmen.backend.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cartitem")
public class CartItem {

    @Id @GeneratedValue
    private Long id;

    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;
}
