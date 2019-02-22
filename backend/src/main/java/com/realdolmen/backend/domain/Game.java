package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "game")
@DiscriminatorValue("Game")
@Getter
@Setter
public class Game extends Article implements Serializable {

    @Column(name = "publisher")
    @Size(max = 100)
    private String publisher;

    @Column(name = "min_age")
    private int minAge;

    @Column(name= "genre")
    @Enumerated
    private GameGenre gameGenre;
}
