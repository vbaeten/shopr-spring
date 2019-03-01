package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertNull;

public class LpMapperTest {

    private LpMapper lpMapper = Mappers.getMapper(LpMapper.class);

    @Test
    public void lpToUserDTO() throws Exception {
//        Lp lp = LpTestDataBuilder.buildLpHelloComputer().build();
//        LpDto lpDto = lpMapper.lpToLpDto(lp);
//
//        assertEquals(lp.getArtist(), lpDto.getArtist());
//        assertEquals(lp.getId(), lpDto.getId());
    }

    @Test
    public void lpDtoToLp() throws Exception {
//        LpDto lpDto = LpTestDataBuilder.buildLpDtoHelloComputer().build();
//        Lp lp = lpMapper.lpDtoToLp(lpDto);
//
//        assertEquals(lpDto.getArtist(), lp.getArtist());
//        assertEquals(lpDto.getId(), lp.getId());
    }

    @Test
    public void testLpShouldAssertNull() {
        Lp lp = lpMapper.lpDtoToLp(null);
        assertNull(lp);
    }
    @Test
    public void testLpDtoShouldAssertNull() {
        LpDto lpDto = lpMapper.lpToLpDto(null);
        assertNull(lpDto);
    }
}
