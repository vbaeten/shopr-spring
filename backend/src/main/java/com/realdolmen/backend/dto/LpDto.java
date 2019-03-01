package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.MusicGenre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LpDto extends ArticleDto {

    private String artist;
    private MusicGenre musicGenre;

    @lombok.Builder(builderClassName = "LpDtoBuilder")
    public LpDto(Long id, String title, double price, String supplier, String type, String artist, MusicGenre musicGenre) {
        super(id, title, price, supplier, type);
        this.artist = artist;
        this.musicGenre = musicGenre;
    }

    public static class LpDtoBuilder extends ArticleDto.Builder {
        LpDtoBuilder() {
            super();
        }
    }
}
