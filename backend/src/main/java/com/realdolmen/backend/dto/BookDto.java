package com.realdolmen.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto extends ArticleDto {

    private String author;
    private long isbn;
    private int pages;
}
