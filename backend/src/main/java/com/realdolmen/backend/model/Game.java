package com.realdolmen.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Game
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
