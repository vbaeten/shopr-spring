package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.dto.GameDto;
import com.realdolmen.backend.mapper.GameMapper;
import com.realdolmen.backend.service.GameService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameFacade {

    private final GameService gameService;
    private final GameMapper gameMapper;

    public GameFacade(GameService gameService, GameMapper gameMapper) {
        this.gameService = gameService;
        this.gameMapper = gameMapper;
    }

    public List<GameDto> findAll() {
        List<Game> games = gameService.findAll();
        return games.stream().map(gameMapper::gameToGameDto).collect(Collectors.toList());
    }

    public GameDto findById(Long id) {
        Game game = gameService.findById(id);
        return gameMapper.gameToGameDto(game);
    }

    public GameDto create(GameDto gameDto) {
        Game game = gameMapper.gameDtoToGame(gameDto);
        Game savedGame = gameService.create(game);
        return gameMapper.gameToGameDto(savedGame);
    }
}
