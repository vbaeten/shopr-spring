package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.dto.FictionDto;

public class FictionTestDataBuilder {

    public static Fiction.Builder buildFictionBook() {
        return Fiction.builder().id(1L).title("A book").price(50).supplier("Dreamland").type("FictionBook");
    }

    public static FictionDto.Builder buildFictionBookDto() {
        return FictionDto.builder().id(1L).title("A book").price(50).supplier("Dreamland").type("FictionBook");
    }

}
