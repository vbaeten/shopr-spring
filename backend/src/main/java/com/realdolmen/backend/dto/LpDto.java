package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.MusicGenre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LpDto extends ArticleDto {

    private String artist;
    private MusicGenre musicGenre;
}
