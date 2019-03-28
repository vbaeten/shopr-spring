package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.enums.GameGenre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GameDto extends ArticleDto {
    private GameGenre gameGenre;
    private Integer minimumAge;
    private String publisher;

    public GameDto(Long articleId, String title, Double price, String supplierId, String type, GameGenre gameGenre, Integer minimumAge, String publisher) {
        super(articleId, title, price, supplierId, type);
        this.gameGenre = gameGenre;
        this.minimumAge = minimumAge;
        this.publisher = publisher;
    }


}
