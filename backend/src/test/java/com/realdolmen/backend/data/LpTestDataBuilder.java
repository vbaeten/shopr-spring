package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.domain.MusicGenre;
import com.realdolmen.backend.dto.LpDto;

public class LpTestDataBuilder {

    public static Lp.LpBuilder buildLpHelloComputer() {
        return Lp.builder()
                .id(1L)
                .title("Good Album")
                .artist("Super Group")
                .price(29)
                .musicGenre(MusicGenre.ROCK)
                .supplier("MediaMarkt")
                .type("Fiction");
    }

    public static LpDto.LpDtoBuilder buildLpDtoHelloComputer() {
        return LpDto.builder()
                .id(1L)
                .title("Good Album")
                .artist("Super Group")
                .price(29)
                .musicGenre(MusicGenre.ROCK)
                .supplier("MediaMarkt")
                .type("Fiction");
    }
}
