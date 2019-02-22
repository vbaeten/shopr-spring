package com.realdolmen.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto {

    private Long id;
    private String title;
    private double price;
    private String supplier;
    private String type;

}
