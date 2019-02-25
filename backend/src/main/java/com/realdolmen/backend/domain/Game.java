package com.realdolmen.backend.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table
@DiscriminatorValue("game")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Game extends Article {

    @Size(max = 100)
    @Column
    private String publisher;
    @Column(name = "minimum_age")
    private int minimumAge;

    @Enumerated(EnumType.STRING)
    @Column(name = "game_genre")
    private GameGenre gameGenre;

    @lombok.Builder(builderClassName = "Builder")
    public Game(@NotNull @Size(max = 100) String title, @NotNull @Digits(integer = 6, fraction = 2) BigDecimal price, @NotNull @Size(max = 100) String supplierId, String type, @Size(max = 100) String publisher, int minimumAge, GameGenre gameGenre) {
        super(title, price, supplierId, type);
        this.publisher = publisher;
        this.minimumAge = minimumAge;
        this.gameGenre = gameGenre;
    }
}
