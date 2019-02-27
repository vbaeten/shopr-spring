package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.GameGenre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameDto extends ArticleDto {

    private String publisher;
    private int minAge;
    private GameGenre gameGenre;

}
