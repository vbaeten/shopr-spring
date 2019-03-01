package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;

public class LpTestDataBuilder {

    public static Lp.LpBuilder buildLpHelloComputer() {
        return Lp.builder().id(5L).title("Hello").artist("RadioHead").price(50);
    }

    public static LpDto.LpDtoBuilder buildLpDtoHelloComputer() {
        return LpDto.builder().id(5L).title("Hello").artist("RadioHead").price(50);
    }
}
