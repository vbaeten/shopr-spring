package com.realdolmen.backend.domain;

import com.realdolmen.backend.domain.enums.GameGenre;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "game")
@DiscriminatorValue("game")
public class Game extends Product {

    private String editor;
    private int pegiRating;

    @Enumerated
    private GameGenre genre;
}
