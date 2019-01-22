package com.realdolmen.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
@DiscriminatorValue(value = "game")
public class Game extends Article implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @NotBlank
    private String studio;
    @NotBlank
    private int age = 6;
    @Enumerated(EnumType.STRING)
    GameGenreEnum gameGenreEnum;



}
