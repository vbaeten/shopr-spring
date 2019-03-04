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

    @lombok.Builder(builderClassName = "BookDtoBuilder")
    public BookDto(Long id, String title, double price, String supplier, String type, String author, long isbn, int pages) {
        super(id, title, price, supplier, type);
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }

    public static class BookDtoBuilder extends ArticleDto.Builder {
        BookDtoBuilder() { super(); }
    }
}
