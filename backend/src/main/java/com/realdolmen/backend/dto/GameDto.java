package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.GameGenre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDto extends ArticleDto {

    private String publisher;
    private int minAge;
    private GameGenre gameGenre;



}
