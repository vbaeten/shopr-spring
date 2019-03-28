package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.dto.GameDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameMapper {
    private final ModelMapper modelMapper;

    public GameDto convertGameToDto(Game game) {
        return modelMapper.map(game, GameDto.class);
    }
}
