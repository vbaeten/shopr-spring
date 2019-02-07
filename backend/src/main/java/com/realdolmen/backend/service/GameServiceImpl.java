package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements  GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public <S extends Game> S save(S entity) {
        return null;
    }

    @Override
    public Game create(Game game) {
        return null;
    }

    @Override
    public Game findById(Long id) {
        return null;
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public void delete(Game game) {
        gameRepository.delete(game);
    }
}
