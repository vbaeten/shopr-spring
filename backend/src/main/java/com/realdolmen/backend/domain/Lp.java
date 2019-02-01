package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table
@DiscriminatorValue("lp")
public class Lp extends Article{

    @Size(max = 100)
    @Column(name = "publisher", unique = true)
    private String publisher;

    @Enumerated(EnumType.STRING)
    private LpGenre lpGenre;

}
