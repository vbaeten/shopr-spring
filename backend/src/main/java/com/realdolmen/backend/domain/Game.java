package com.realdolmen.backend.domain;

import com.realdolmen.backend.domain.enums.GameGenre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@DiscriminatorValue("game")
public class Game extends Article {
    @Column(name = "game_genre")
    @Enumerated(EnumType.STRING)
    private GameGenre gameGenre;

    private Integer minimumAge;

    private String publisher;

    @lombok.Builder(builderClassName = "GameBuilder")
    public Game(Long versionId, Long articleId, String title, Double price, String supplierId, String type, GameGenre gameGenre, Integer minimumAge, String publisher) {
        super(versionId, articleId, title, price, supplierId, type);
        this.gameGenre = gameGenre;
        this.minimumAge = minimumAge;
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        if (!super.equals(o)) return false;
        Game game = (Game) o;
        return gameGenre == game.gameGenre &&
                Objects.equals(minimumAge, game.minimumAge) &&
                Objects.equals(publisher, game.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gameGenre, minimumAge, publisher);
    }

    public static class GameBuilder extends ArticleBuilder {
        GameBuilder() {
            super();
        }
    }
}
