package com.realdolmen.backend.domain;

import lombok.Getter;

@Getter
public enum NonFictionSubject {

    HISTORY("history"),
    COOKING("cooking"),
    SCIENCE("science"),
    SPORTS("sports");


    private String nonFictionSubjectName;

    NonFictionSubject(String nonFictionSubjectName) {
        this.nonFictionSubjectName = nonFictionSubjectName;
    }

}
