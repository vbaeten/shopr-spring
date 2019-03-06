package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.domain.Subject;
import com.realdolmen.backend.dto.NonFictionDto;

public class NonFictionTestDataBuilder {

    public static NonFiction.NonFictionBuilder buildNonFictionBook() {
        return NonFiction.builder()
                .id(1L)
                .title("A book")
                .author("Johnny")
                .price(50)
                .supplier("Dreamland")
                .type("Fiction")
                .pages(120)
                .isbn(111-11-1111-111-3)
                .subject(Subject.SCIENCE);
    }

    public static NonFictionDto.NonFictionDtoBuilder buildNonFictionBookDto() {
        return NonFictionDto.builder()
                .id(1L)
                .title("A book")
                .author("Johnny")
                .price(50)
                .supplier("Dreamland")
                .type("Fiction")
                .pages(120)
                .isbn(111-11-1111-111-3)
                .subject(Subject.SCIENCE);
    }
}
