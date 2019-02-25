package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.repository.GameReopsitory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {

    private GameReopsitory gameReopsitory;

    @Override
    public Game save(Game game) {
        return gameReopsitory.save(game);
    }

    @Override
    public Game findById(Long id) {
        return gameReopsitory.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Game> findAll() {
        return gameReopsitory.findAll();
    }

    @Override
    public void delete(Game game) {
        gameReopsitory.delete(game);
    }
}
