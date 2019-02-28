package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "game")
@DiscriminatorValue("Game")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Game extends Article implements Serializable {

    @Column(name = "publisher")
    @Size(max = 100)
    private String publisher;

    @Column(name = "min_age")
    private int minAge;

    @Column(name= "genre")
    @Enumerated
    private GameGenre gameGenre;

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
