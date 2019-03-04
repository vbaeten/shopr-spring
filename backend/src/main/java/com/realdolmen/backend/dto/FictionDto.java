package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.BookGenre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FictionDto extends BookDto {

    private BookGenre bookGenre;
    private String synopsis;


//    @lombok.Builder(builderClassName = "FictionDtoBuilder")
//    public FictionDto(Long id, String title, double price, String supplier, String type, String author, long isbn, int pages, BookGenre bookGenre, String synopsis) {
//        super(id, title, price, supplier, type, author, isbn, pages);
//        this.bookGenre = bookGenre;
//        this.synopsis = synopsis;
//    }
//
//    public static class FictionDtoBuilder extends BookDto.Builder {
//        FictionDtoBuilder() {super();}
//    }
}
