package com.realdolmen.backend.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Orderline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderlineId;

    @ManyToOne
    private Article article;

    @Digits(integer = 6, fraction = 2)
    private Long subTotal;
    @Digits(integer = 6, fraction = 0)
    @NotNull
    private Long quantity;
    @Digits(integer = 6, fraction = 2)
    private Long totalPrice;
}
