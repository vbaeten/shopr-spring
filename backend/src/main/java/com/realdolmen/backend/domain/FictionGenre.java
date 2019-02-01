package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FictionGenre {

    THRILLER("thriller"),
    FANTASY("fantasy"),
    DETECTIVE("detective"),
    ROMANCE("romance"),
    SCIFI("sci-fi");

    private String fictionGenre;

    public void setFictionGenre(String fictionGenre) {
        this.fictionGenre = fictionGenre;
    }

}
