package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.dto.NonFictionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NonFictionMapper {

    NonFictionDto nonFictionToNonFictionDto(Fiction fiction);

    Fiction nonFictionDtoToFiction(NonFictionDto nonFictionDto);
}
