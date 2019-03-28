package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.enums.LpGenre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LpDto extends ArticleDto {
    private LpGenre lpGenre;
    private String artist;

    public LpDto(Long articleId, String title, Double price, String supplierId, String type, LpGenre lpGenre, String artist) {
        super(articleId, title, price, supplierId, type);
        this.lpGenre = lpGenre;
        this.artist = artist;
    }

}
