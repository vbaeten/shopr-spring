package com.realdolmen.shoprbackend.domain;

import javax.persistence.*;

@Entity
@Table(name = "order_line")
public class OrderLine {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Item item;

    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;

    @Transient
    private double subTotal;
    private int quantity;


    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
