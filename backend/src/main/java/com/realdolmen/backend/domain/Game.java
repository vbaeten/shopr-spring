package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "game")
@DiscriminatorValue("Game")
@Getter
@Setter
@NoArgsConstructor
public class Game extends Article implements Serializable {

    @Column(name = "publisher")
    @Size(max = 100)
    private String publisher;

    @Column(name = "min_age")
    private int minAge;

    @Column(name = "genre")
    @Enumerated
    private GameGenre gameGenre;

    @lombok.Builder(builderClassName = "GameBuilder")
    public Game(Long id, @NotNull @Size(max = 100) String title, @NotNull @Digits(integer = 6, fraction = 2) double price, @NotNull @Size(max = 100) String supplier, String type, @Size(max = 100) String publisher, int minAge, GameGenre gameGenre) {
        super(id, title, price, supplier, type);
        this.publisher = publisher;
        this.minAge = minAge;
        this.gameGenre = gameGenre;
    }

    public static class GameBuilder extends Builder {
        GameBuilder() {
            super();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Game game = (Game) o;
        return minAge == game.minAge &&
                publisher.equals(game.publisher) &&
                gameGenre == game.gameGenre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publisher, minAge, gameGenre);
    }
}
