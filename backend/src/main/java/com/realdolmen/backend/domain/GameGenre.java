package com.realdolmen.backend.domain;

import lombok.Getter;

@Getter
public enum GameGenre {
    MMORPG("MMO/RPG"),
    RPG("RPG"),
    FPS("FPS"),
    RTS("RTS"),
    RACE("Race");

    private String gameGenreName;

    GameGenre(String gameGenreName) {
        this.gameGenreName = gameGenreName;
    }

}
