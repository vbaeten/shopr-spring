package com.realdolmen.backend.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "article")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="type")
public class Article implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String title;

    @Column
    private double price;

    @Column
    private String Supplier;

    @Column(name="type", insertable = false, updatable = false)
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
