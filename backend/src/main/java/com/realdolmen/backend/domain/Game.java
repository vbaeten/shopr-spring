package com.realdolmen.backend.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "game")
@DiscriminatorValue("Game")
public class Game extends Article implements Serializable {

    @Column(name = "publisher")
    @Size(max = 100)
    private String publisher;

    @Column(name = "min_age")
    private int minAge;

    @Column(name= "genre")
    @Enumerated
    private GameGenre gameGenre;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public GameGenre getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(GameGenre gameGenre) {
        this.gameGenre = gameGenre;
    }
}
