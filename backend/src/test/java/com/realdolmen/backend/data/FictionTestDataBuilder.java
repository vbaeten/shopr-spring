package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.dto.FictionDto;

public class FictionTestDataBuilder {

    public static Fiction.FictionBuilder buildFictionBook() {
        return Fiction.builder()
                .id(1L)
                .title("A book").price(50).supplier("Dreamland").type("FictionBook");
    }

    public static FictionDto.FictionDtoBuilder buildFictionBookDto() {
        return FictionDto.builder().id(1L).title("A book").price(50).supplier("Dreamland").type("FictionBook");
    }

}
