package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.enums.BookfictionGenre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookfictionDto extends BookDto {
    private BookfictionGenre bookfictionGenre;
    private String summary;

    public BookfictionDto(Long articleId, String title, Double price, String supplierId, String type, String author, String isbn, Integer numberOfPages, BookfictionGenre bookfictionGenre, String summary) {
        super(articleId, title, price, supplierId, type, author, isbn, numberOfPages);
        this.bookfictionGenre = bookfictionGenre;
        this.summary = summary;
    }

}
