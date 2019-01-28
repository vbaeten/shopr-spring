package com.realdolmen.backend.Domain;

import com.realdolmen.backend.Domain.enums.GameGenre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter
@Entity
@DiscriminatorValue("game")
public class Game extends Article {

    @Enumerated(EnumType.STRING)
    private GameGenre gamegenre;

    private Integer minimumAge;

    private String publisher;

}
