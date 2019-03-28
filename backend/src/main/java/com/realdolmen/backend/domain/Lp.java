package com.realdolmen.backend.domain;

import com.realdolmen.backend.domain.enums.LpGenre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("lp")
public class Lp extends Article {
    @Column(name = "lp_genre")
    @Enumerated(EnumType.STRING)
    private LpGenre lpGenre;

    private String artist;

    @lombok.Builder(builderClassName = "LpBuilder")
    public Lp(Long versionId, Long articleId, String title, Double price, String supplierId, String type, LpGenre lpGenre, String artist) {
        super(versionId, articleId, title, price, supplierId, type);
        this.lpGenre = lpGenre;
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lp)) return false;
        if (!super.equals(o)) return false;
        Lp lp = (Lp) o;
        return lpGenre == lp.lpGenre &&
                Objects.equals(artist, lp.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lpGenre, artist);
    }

    public static class LpBuilder extends ArticleBuilder {
        LpBuilder() {
            super();
        }
    }
}
