package com.realdolmen.backend.domain;

import lombok.Getter;

@Getter
public enum FictionGenre {

    THRILLER("Thriller"),
    FANTASY("Fantasy"),
    DETECTIVE("Detective"),
    ROMANCE("Romance"),
    SCIFI("Sci-fi");

    private String fictionGenreName;

    FictionGenre(String fictionGenreName) {
        this.fictionGenreName = fictionGenreName;
    }
}
