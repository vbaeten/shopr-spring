package com.realdolmen.backend.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Orderline extends BaseObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderlineId;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Article article;

    @Digits(integer = 6, fraction = 2)
    private Double subTotal;
    @Digits(integer = 6, fraction = 0)
    @NotNull
    private Long quantity;
}
