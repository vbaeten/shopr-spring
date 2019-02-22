package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "lp")
@DiscriminatorValue("Lp")
@Getter
@Setter
public class Lp extends Article implements Serializable {

    @Column(name="artist")
    @Size(max = 100)
    private String artist;

    @Column(name="genre")
    private MusicGenre musicGenre;
}
