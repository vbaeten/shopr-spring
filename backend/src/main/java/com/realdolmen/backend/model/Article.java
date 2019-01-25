package com.realdolmen.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static javax.persistence.DiscriminatorType.STRING;

@Entity
@Data
@DiscriminatorColumn(discriminatorType = STRING , name = "type")
@Inheritance(strategy = InheritanceType.JOINED)
public class Article implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @NotBlank
    private String title;
   @NotNull
    @Digits(integer=6, fraction = 2)
    private int price;
    private String distributor;
    @Column(insertable = false, updatable = false)
    private String type;



}
