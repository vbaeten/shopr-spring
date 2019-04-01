package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Bookfiction;
import com.realdolmen.backend.dto.BookfictionDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookfictionMapper {

    private final ModelMapper modelMapper;

    public BookfictionDto convertBookfictionToDto(Bookfiction bookfiction) {
        return modelMapper.map(bookfiction, BookfictionDto.class);
    }

    public Bookfiction convertBookfictionDtoToBookFiction(BookfictionDto bookfictionDto) {
        return modelMapper.map(bookfictionDto, Bookfiction.class);
    }
}
