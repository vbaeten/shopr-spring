package com.realdolmen.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto extends ArticleDto {

    private String author;
    private long isbn;
    private int pages;
}
