package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Booknonfiction;
import com.realdolmen.backend.dto.BooknonfictionDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BooknonfictionMapper {

    private final ModelMapper modelMapper;

    public BooknonfictionDto convertBooknonfictionToDto(Booknonfiction booknonfiction) {
        return modelMapper.map(booknonfiction, BooknonfictionDto.class);
    }
}
