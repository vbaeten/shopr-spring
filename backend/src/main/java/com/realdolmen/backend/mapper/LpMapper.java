package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;
import org.modelmapper.ModelMapper;

public class LpMapper {
    private static ModelMapper modelMapper;

    private LpMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static LpDto convertLpToDto(Lp lp) {
        return modelMapper.map(lp, LpDto.class);
    }
}
