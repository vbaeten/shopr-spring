package com.realdolmen.backend.mapper;

import com.realdolmen.backend.data.RatingTestDataBuilder;
import com.realdolmen.backend.domain.Rating;
import com.realdolmen.backend.dto.RatingDto;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RatingMapperTest {

    private RatingMapper ratingMapper = Mappers.getMapper(RatingMapper.class);

    @Test
    public void ratingToRatingDTO() throws Exception {
        Rating rating = RatingTestDataBuilder.buildRating1().build();
        RatingDto ratingDto = ratingMapper.ratingToRatingDto(rating);

        assertEquals(rating.getUser().getFirstName(), ratingDto.getUser().getFirstName());
        assertEquals(rating.getId(), ratingDto.getId());
    }

    @Test
    public void ratingDtoToRating() throws Exception {
        RatingDto ratingDto = RatingTestDataBuilder.buildRatingDto1().build();
        Rating rating = ratingMapper.ratingDtoToRating(ratingDto);

        assertEquals(ratingDto.getUser().getName(), rating.getUser().getName());
        assertEquals(ratingDto.getId(), rating.getId());
    }

    @Test
    public void testRatingShouldAssertNull() {
        Rating rating = ratingMapper.ratingDtoToRating(null);
        assertNull(rating);
    }
    @Test
    public void testRatingDtoShouldAssertNull() {
        RatingDto ratingDto = ratingMapper.ratingToRatingDto(null);
        assertNull(ratingDto);
    }
}
