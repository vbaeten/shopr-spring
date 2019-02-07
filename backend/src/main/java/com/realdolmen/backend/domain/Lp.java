package com.realdolmen.backend.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "lp")
@DiscriminatorValue("Lp")
public class Lp extends Article implements Serializable {

    @Column(name="artist")
    @Size(max = 100)
    private String artist;

    @Column(name="genre")
    private MusicGenre musicGenre;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public MusicGenre getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(MusicGenre musicGenre) {
        this.musicGenre = musicGenre;
    }
}
