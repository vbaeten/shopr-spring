package com.realdolmen.backend.dto;

import lombok.*;

@Builder(builderClassName = "Builder")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {

    private Long id;
    private int score;
    private String description;
    private UserDto user;
    private ArticleDto article;
}
