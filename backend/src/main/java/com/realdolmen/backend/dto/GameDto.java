package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.GameGenre;

public class GameDto extends ArticleDto {

    private String publisher;
    private int minAge;
    private GameGenre gameGenre;

}
