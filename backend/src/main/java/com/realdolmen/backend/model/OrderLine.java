package com.realdolmen.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class OrderLine implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToOne
    private Article article;

    @Transient
    private int articleid;

    @OneToOne
    private OrderFromShop orderFromShop;

    private int amount;

    private int priceOrderDate;

    @Transient
    private int userid;


}
