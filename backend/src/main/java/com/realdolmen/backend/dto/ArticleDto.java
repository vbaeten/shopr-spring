package com.realdolmen.backend.dto;

import lombok.*;

@Getter
@Setter
@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private Long id;
    private String title;
    private double price;
    private String supplier;
    private String type;

}
