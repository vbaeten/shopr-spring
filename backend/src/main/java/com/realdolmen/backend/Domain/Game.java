package com.realdolmen.backend.Domain;

import com.realdolmen.backend.Domain.enums.Gamegenre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@DiscriminatorValue("game")
public class Game extends Article {

    @Enumerated(EnumType.STRING)
    private Gamegenre gamegenre;

    private Integer minimumAge;

    private String publisher;

}
