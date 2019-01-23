package com.realdolmen.shoprbackend.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="lps")
@DiscriminatorValue("lp")
public class Lp extends Item {


    @Size(max=100)
    private String publisher;

    @Enumerated(EnumType.STRING)
    private LpGenre genre;


    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LpGenre getGenre() {
        return genre;
    }

    public void setGenre(LpGenre genre) {
        this.genre = genre;
    }
}
