package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.MusicGenre;
import lombok.*;

@Getter
@Setter
@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
public class LpDto extends ArticleDto {

    private String artist;
    private MusicGenre musicGenre;

}
