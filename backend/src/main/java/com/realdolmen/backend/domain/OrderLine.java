package com.realdolmen.backend.domain;

import javax.persistence.*;

@Entity
@Table(name= "order_line")
public class OrderLine {

    @Id
    @GeneratedValue
    private int id;

    private int quantity;

    private double subTotal;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
