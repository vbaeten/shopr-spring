package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.dto.GameDto;
import org.modelmapper.ModelMapper;

public class GameMapper {
    private static ModelMapper modelMapper;

    private GameMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static GameDto convertGameToDto(Game game) {
        return modelMapper.map(game, GameDto.class);
    }
}
