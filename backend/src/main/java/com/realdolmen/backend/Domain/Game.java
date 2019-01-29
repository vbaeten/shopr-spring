package com.realdolmen.backend.Domain;

import com.realdolmen.backend.Domain.enums.GameGenre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@DiscriminatorValue("game")
public class Game extends Article {
    @Column(name = "game_genre")
    @Enumerated(EnumType.STRING)
    private GameGenre gameGenre;

    private Integer minimumAge;

    private String publisher;

}
