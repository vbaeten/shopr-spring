package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    private final GameRepository gameRepository;

    public Game save(Game game) {
        return gameRepository.saveAndFlush(game);
    }

    public void delete(Game game) {
        gameRepository.delete(game);
    }

    public Game findById(Long id) {
        return gameRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }
}
