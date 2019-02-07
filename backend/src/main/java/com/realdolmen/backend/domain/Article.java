package com.realdolmen.backend.domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "article")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public class Article implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    @NotNull
    @Size(max = 100)
    private String title;

    @Column
    @NotNull
    @Digits(integer = 6, fraction = 2)
    private double price;

    @Column
    @NotNull
    @Size(max = 100)
    private String Supplier;

    @Column(name = "type", insertable = false, updatable = false)
    private String type;

    @OneToMany
    @JoinColumn(name="order_id")
    private List<OrderLine> orderLines;

    @OneToMany
    @JoinColumn(name="score")
    private List<Rating> ratings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
