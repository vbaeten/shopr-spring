package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.dto.NonFictionDto;

public class NonFictionTestDataBuilder {

    public static NonFiction.Builder buildNonFictionBook() {
        return NonFiction.builder().id(1L).title("A book").price(50).supplier("Dreamland").type("NonFictionBook");
    }

    public static NonFictionDto.Builder buildNonFictionBookDto() {
        return NonFictionDto.builder().id(1L).title("A book").price(50).supplier("Dreamland").type("NonFictionBook");
    }
}
