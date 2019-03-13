package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.BookGenre;
import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.dto.FictionDto;

public class FictionTestDataBuilder {

    public static Fiction.FictionBuilder buildFictionBook() {
        return Fiction.builder()
                .id(1L)
                .title("A book")
                .author("Johnny")
                .bookGenre(BookGenre.ROMANCE)
                .synopsis("A guy walks in a bar ...")
                .price(50)
                .supplier("Dreamland")
                .type("Fiction")
                .pages(30)
                .isbn("111-11-1111-111-2");
    }

    public static FictionDto.FictionDtoBuilder buildFictionBookDto() {
        return FictionDto.builder()
                .id(1L)
                .title("A book")
                .author("Johnny")
                .bookGenre(BookGenre.ROMANCE)
                .synopsis("A guy walks in a bar ...")
                .price(50)
                .supplier("Dreamland")
                .type("Fiction")
                .pages(30)
                .isbn("111-11-1111-111-2");
    }
}
