package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NonFictionSubject {

    HISTORY("history"),
    COOKING("cooking"),
    SCIENCE("science"),
    SPORTS("sports");


    private String nonFictionSubject;

    public void setNonFictionSubject(String nonFictionSubject) {
        this.nonFictionSubject = nonFictionSubject;
    }

}
