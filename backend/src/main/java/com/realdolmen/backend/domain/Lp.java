package com.realdolmen.backend.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "lp")
@DiscriminatorValue("Lp")
@Getter
@Setter
@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
public class Lp extends Article implements Serializable {

    @Column(name="artist")
    @Size(max = 100)
    private String artist;

    @Column(name="genre")
    private MusicGenre musicGenre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Lp lp = (Lp) o;
        return artist.equals(lp.artist) &&
                musicGenre == lp.musicGenre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), artist, musicGenre);
    }
}
