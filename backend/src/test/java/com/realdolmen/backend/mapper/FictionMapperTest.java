package com.realdolmen.backend.mapper;

import com.realdolmen.backend.data.FictionTestDataBuilder;
import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.dto.FictionDto;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FictionMapperTest {

    private FictionMapper fictionMapper = Mappers.getMapper(FictionMapper.class);

    @Test
    public void fictionToFictionDTO() throws Exception {
        Fiction fiction = FictionTestDataBuilder.buildFictionBook().build();
        FictionDto fictionDto = fictionMapper.fictionToFictionDto(fiction);

        assertEquals(fiction.getSynopsis(), fictionDto.getSynopsis());
        assertEquals(fiction.getId(), fictionDto.getId());
    }

    @Test
    public void fictionDtoToFiction() throws Exception {
        FictionDto fictionDto = FictionTestDataBuilder.buildFictionBookDto().build();
        Fiction fiction = fictionMapper.fictionDtoToFiction(fictionDto);

        assertEquals(fictionDto.getPages(), fiction.getPages());
        assertEquals(fictionDto.getId(), fiction.getId());
    }

    @Test
    public void testFictionShouldAssertNull() {
        Fiction fiction = fictionMapper.fictionDtoToFiction(null);
        assertNull(fiction);
    }
    @Test
    public void testFictionDtoShouldAssertNull() {
        FictionDto fictionDto = fictionMapper.fictionToFictionDto(null);
        assertNull(fictionDto);
    }

}
