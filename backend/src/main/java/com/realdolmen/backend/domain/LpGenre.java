package com.realdolmen.backend.domain;

import lombok.Getter;

@Getter
public enum LpGenre {

    CLASSIC("Classic"),
    POP("pop"),
    ROCK("rock"),
    DANCE("dance"),
    RNB("r&b"),
    HIPHOP("hiphop");

    private String lpGenreName;

    LpGenre(String lpGenreName) {
        this.lpGenreName = lpGenreName;
    }

}
