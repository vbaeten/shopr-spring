package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.enums.BooknonfictionGenre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BooknonfictionDto extends BookDto {
    private BooknonfictionGenre booknonfictionGenre;


    @lombok.Builder(builderClassName = "BooknonfictionDtoBuilder")
    public BooknonfictionDto(Long versionId, Long articleId, String title, Double price, String supplierId, String type, String author, String isbn, Integer numberOfPages, BooknonfictionGenre booknonfictionGenre) {
        super(versionId, articleId, title, price, supplierId, type, author, isbn, numberOfPages);
        this.booknonfictionGenre = booknonfictionGenre;
    }

    public static class BooknonfictionDtoBuilder extends BookDto.BookDtoBuilder {
        BooknonfictionDtoBuilder() {
            super();
        }
    }
}