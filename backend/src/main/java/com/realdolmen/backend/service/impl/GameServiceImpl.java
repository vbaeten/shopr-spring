package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repositories.GameRepository;
import com.realdolmen.backend.service.GameService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game create(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game findById(Long articleId) {
        return gameRepository.findById(articleId).orElseThrow(NotFoundException::new);
    }

    @Override
    public <S extends Game> S save(S entity) {
        return gameRepository.save(entity);
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }
}
