package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.GameGenre;
import lombok.*;

@Getter
@Setter
@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
public class GameDto extends ArticleDto {

    private String publisher;
    private int minAge;
    private GameGenre gameGenre;



}
