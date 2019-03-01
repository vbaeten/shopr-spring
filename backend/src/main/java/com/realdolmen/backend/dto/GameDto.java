package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.GameGenre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GameDto extends ArticleDto {

    private String publisher;
    private int minAge;
    private GameGenre gameGenre;

    @lombok.Builder(builderClassName = "GameDtoBuilder")
    public GameDto(Long id, String title, double price, String supplier, String type, String publisher, int minAge, GameGenre gameGenre) {
        super(id, title, price, supplier, type);
        this.publisher = publisher;
        this.minAge = minAge;
        this.gameGenre = gameGenre;
    }

    public static class GameDtoBuilder extends GameDto.Builder {
        GameDtoBuilder() { super(); }
    }

}
