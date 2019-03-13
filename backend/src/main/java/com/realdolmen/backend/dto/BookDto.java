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
    private int pages;

    @lombok.Builder(builderClassName = "BookDtoBuilder")
    public BookDto(Long id, String title, double price, String supplier, String type, String author, String isbn, int pages) {
        super(id, title, price, supplier, type);
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }

    public static class BookDtoBuilder extends Builder {
        BookDtoBuilder() { super(); }
    }
}
