package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements  GameService {

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
        return null;
    }

    @Override
    public void delete(Game entity) {

    }
}
