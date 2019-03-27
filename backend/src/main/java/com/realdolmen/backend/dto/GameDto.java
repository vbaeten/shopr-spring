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

    @lombok.Builder(builderClassName = "GameDtoBuilder")
    public GameDto(Long versionId, Long articleId, String title, Double price, String supplierId, String type, GameGenre gameGenre, Integer minimumAge, String publisher) {
        super(versionId, articleId, title, price, supplierId, type);
        this.gameGenre = gameGenre;
        this.minimumAge = minimumAge;
        this.publisher = publisher;
    }

    public static class GameDtoBuilder extends ArticleDto.ArticleDtoBuilder {
        GameDtoBuilder() {
            super();
        }
    }
}
