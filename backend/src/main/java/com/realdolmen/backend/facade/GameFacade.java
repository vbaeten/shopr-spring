package com.realdolmen.backend.facade;

import com.realdolmen.backend.mapper.GameMapper;
import com.realdolmen.backend.service.GameService;
import org.springframework.stereotype.Component;

@Component
public class GameFacade {

    private final GameService gameService;
    private final GameMapper gameMapper;

    public GameFacade(GameService gameService, GameMapper gameMapper) {
        this.gameService = gameService;
        this.gameMapper = gameMapper;
    }
}
