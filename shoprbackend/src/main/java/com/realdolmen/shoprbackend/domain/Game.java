package com.realdolmen.shoprbackend.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Games")
public class Game extends Item {


    @Size(max = 100)
    private String publisher;

    private short minAge;

    @Enumerated(EnumType.STRING)
    private GameGenre genre;


    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public short getMinAge() {
        return minAge;
    }

    public void setMinAge(short minAge) {
        this.minAge = minAge;
    }

    public GameGenre getGenre() {
        return genre;
    }

    public void setGenre(GameGenre genre) {
        this.genre = genre;
    }
}
