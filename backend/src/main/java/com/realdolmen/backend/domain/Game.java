package com.realdolmen.backend.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table
@DiscriminatorValue("game")
public class Game extends Article{

    @Size(max = 100)
    @Column(unique = true)
    private String publisher;
    @Column(name = "minimum_age")
    private int minimumAge;

    @Enumerated(EnumType.STRING)
    @Column(name = "game_genre")
    private GameGenre gameGenre;

}
