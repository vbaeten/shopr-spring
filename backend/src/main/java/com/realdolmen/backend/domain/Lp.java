package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "lp")
@DiscriminatorValue("Lp")
@Getter
@Setter
@NoArgsConstructor
public class Lp extends Article implements Serializable {

    @Column(name = "artist")
    @Size(max = 100)
    private String artist;

    @Column(name = "genre")
    private MusicGenre musicGenre;

//    @lombok.Builder(builderClassName = "LpBuilder")
    public Lp(Long id, @NotNull @Size(max = 100) String title, @NotNull @Digits(integer = 6, fraction = 2) double price, @NotNull @Size(max = 100) String supplier, String type, @Size(max = 100) String artist, MusicGenre musicGenre) {
        super(id, title, price, supplier, type);
        this.artist = artist;
        this.musicGenre = musicGenre;
    }

//    public static class LpBuilder extends Builder {
//        LpBuilder() {
//            super();
//        }
//    }

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
