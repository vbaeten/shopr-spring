package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Rating;
import com.realdolmen.backend.dto.RatingDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    RatingDto ratingToRatingDto(Rating rating);
    Rating ratingDtoToRating(RatingDto ratingDto);
}
