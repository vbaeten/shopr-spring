package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LpMapper {
    private final ModelMapper modelMapper;

    public LpDto convertLpToDto(Lp lp) {
        return modelMapper.map(lp, LpDto.class);
    }
}
