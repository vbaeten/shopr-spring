package com.realdolmen.backend.Domain;

import com.realdolmen.backend.Domain.enums.Lpgenre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter
@Entity
@DiscriminatorValue("lp")
public class Lp extends Article {
    @Enumerated(EnumType.STRING)
    private Lpgenre lpgenre;

    private String artist;

}
