package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.MusicGenre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LpDto extends ArticleDto {

    private String artist;
    private MusicGenre musicGenre;

}
