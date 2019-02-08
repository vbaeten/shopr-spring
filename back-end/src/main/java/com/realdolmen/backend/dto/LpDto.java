package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.LpGenre;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Mapstruct 1.2.0.Final does not support mapping via builders.
 * That is why both the @Setter and @Builder annotations are being used.
 * Only use the builder when creating new instances!
 */
@Getter
@Setter
@NoArgsConstructor
public class LpDto {
    private Long id;
    private String title;
    private Double price;
    private String type;
    private String artist;
    private LpGenre lpGenre;

    @Builder
    public LpDto(String title, Double price, String type, String artist, LpGenre lpGenre) {
        this.title = title;
        this.price = price;
        this.type = type;
        this.artist = artist;
        this.lpGenre = lpGenre;
    }
}
