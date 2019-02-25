package com.realdolmen.backend.domain;

import lombok.Getter;

@Getter
public enum FictionGenre {

    THRILLER("thriller"),
    FANTASY("fantasy"),
    DETECTIVE("detective"),
    ROMANCE("romance"),
    SCIFI("sci-fi");

    private String fictionGenreName;

    FictionGenre(String fictionGenreName) {
        this.fictionGenreName = fictionGenreName;
    }
}
