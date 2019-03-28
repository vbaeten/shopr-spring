package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Booknonfiction;
import com.realdolmen.backend.dto.BooknonfictionDto;
import org.modelmapper.ModelMapper;

public class BooknonfictionMapper {

    private static ModelMapper modelMapper;

    private BooknonfictionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static BooknonfictionDto convertBooknonfictionToDto(Booknonfiction booknonfiction) {
        return modelMapper.map(booknonfiction, BooknonfictionDto.class);
    }
}
