package com.realdolmen.backend.mapper;

import com.realdolmen.backend.data.NonFictionTestDataBuilder;
import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.dto.NonFictionDto;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class NonFictionMapperTest {

    private NonFictionMapper nonFictionMapper = Mappers.getMapper(NonFictionMapper.class);

    @Test
    public void nonFictionToFictionDTO() throws Exception {
        NonFiction nonFiction = NonFictionTestDataBuilder.buildNonFictionBook().build();
        NonFictionDto nonFictionDto = nonFictionMapper.nonFictionToNonFictionDto(nonFiction);

        assertEquals(nonFiction.getAuthor(), nonFictionDto.getAuthor());
        assertEquals(nonFiction.getId(), nonFictionDto.getId());
    }

    @Test
    public void nonFictionDtoToFiction() throws Exception {
        NonFictionDto nonFictionDto = NonFictionTestDataBuilder.buildNonFictionBookDto().build();
        NonFiction nonFiction = nonFictionMapper.nonFictionDtoToFiction(nonFictionDto);

        assertEquals(nonFictionDto.getPages(), nonFiction.getPages());
        assertEquals(nonFictionDto.getId(), nonFiction.getId());
    }

    @Test
    public void testFictionShouldAssertNull() {
        NonFiction nonFiction = nonFictionMapper.nonFictionDtoToFiction(null);
        assertNull(nonFiction);
    }
    @Test
    public void testFictionDtoShouldAssertNull() {
        NonFictionDto nonFictionDto = nonFictionMapper.nonFictionToNonFictionDto(null);
        assertNull(nonFictionDto);
    }

}
