package com.realdolmen.backend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "favorite_product")
public class FavoriteProduct extends Product {

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;
}
