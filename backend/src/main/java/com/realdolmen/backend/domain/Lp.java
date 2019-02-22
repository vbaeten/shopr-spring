package com.realdolmen.backend.domain;

import com.realdolmen.backend.domain.enums.LpGenre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@DiscriminatorValue("lp")
public class Lp extends Article {
    @Column(name = "lp_genre")
    @Enumerated(EnumType.STRING)
    private LpGenre lpGenre;

    private String artist;

}
