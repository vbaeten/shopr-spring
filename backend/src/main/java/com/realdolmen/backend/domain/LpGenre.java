package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LpGenre {

    CLASSIC("Classic"),
    POP("pop"),
    ROCK("rock"),
    DANCE("dance"),
    RNB("r&b"),
    HIPHOP("hiphop");

    private String lpGenre;

    public void setLpGenre(String lpGenre) {
        this.lpGenre = lpGenre;
    }

}
