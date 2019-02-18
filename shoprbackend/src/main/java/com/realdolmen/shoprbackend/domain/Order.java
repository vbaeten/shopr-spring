package com.realdolmen.shoprbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue
    private Long Id;

    @Transient
    private Timestamp date;

    @OneToMany(cascade = {MERGE, REMOVE},fetch = FetchType.EAGER)
    @JoinColumn
    @JsonIgnore
    private List<OrderLine> orderLines;


    @ManyToOne(cascade =ALL)
    @JoinColumn
    private User user;

    private double totalPrice;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
