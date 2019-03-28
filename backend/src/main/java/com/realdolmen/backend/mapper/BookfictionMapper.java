package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Bookfiction;
import com.realdolmen.backend.dto.BookfictionDto;
import org.modelmapper.ModelMapper;

public class BookfictionMapper {

    private static ModelMapper modelMapper;

    private BookfictionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static BookfictionDto convertBookfictionToDto(Bookfiction bookfiction) {
        return modelMapper.map(bookfiction, BookfictionDto.class);
    }
}
