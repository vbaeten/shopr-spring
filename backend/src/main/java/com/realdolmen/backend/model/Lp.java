package com.realdolmen.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@DiscriminatorValue(value = "lp")
public class Lp extends Article
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @NotBlank
    private String artist;
    @Enumerated(EnumType.STRING)
    LpGenreEnum lpGenreEnum;


}
