package com.realdolmen.backend.model;

import com.realdolmen.backend.model.enums.GameGenreEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@DiscriminatorValue(value = "game")
public class Game extends Article
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @NotBlank
    private String studio;
    @NotNull
    private int age = 6;
    @Enumerated(EnumType.STRING)
    GameGenreEnum gameGenreEnum;
    @Transient
    private String genre;


}
