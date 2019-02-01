package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GameGenre {
    MMORPG("MMO/RPG"),
    RPG("RPG"),
    FPS("FPS"),
    RTS("RTS"),
    RACE("Race");

    private String gameGenre;

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

}
