package com.realdolmen.backend.dto;

import lombok.*;

@Getter
@Setter
@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
public class BookDto extends ArticleDto {

    private String author;
    private long isbn;
    private int pages;
}
