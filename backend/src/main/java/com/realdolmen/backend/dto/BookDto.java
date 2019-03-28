package com.realdolmen.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDto extends ArticleDto {
    private String author;
    private String isbn;
    private Integer numberOfPages;

    public BookDto(Long articleId, String title, Double price, String supplierId, String type, String author, String isbn, Integer numberOfPages) {
        super(articleId, title, price, supplierId, type);
        this.author = author;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
    }


}

