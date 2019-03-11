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

    @Transient
    private String type;

    @Transient
    private String title;

    @ManyToOne(cascade = CascadeType.MERGE)
    private OrderFromShop orderFromShop;

    private int amount;

    @Column(name = "priceOrderDate")
    private int price;

    @Transient
    private int userid;


}
