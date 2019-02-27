package com.realdolmen.backend.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ratings")
public class Rating {

    @Id @GeneratedValue
    private Long id;

    private double rating;

    @ManyToOne
    private Product product;
}
