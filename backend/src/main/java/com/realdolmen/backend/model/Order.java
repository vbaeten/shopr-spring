package com.realdolmen.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Order implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private Date orderDate;
    @OneToMany
    private List<Article> articleList = new ArrayList<>();
    @ManyToOne
    User user;




}
