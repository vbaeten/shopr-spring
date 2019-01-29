package com.realdolmen.shoprbackend.services;

import com.realdolmen.shoprbackend.domain.Game;
import com.realdolmen.shoprbackend.exception.NotFoundException;
import com.realdolmen.shoprbackend.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GameService implements CrudService<Game, Long> {

    private final GameRepository gameRepository;



    @Override
    public <S extends Game> S save(S game) {
        return gameRepository.save(game);
    }

    @Override
    public Game findById(Long id) {

        return gameRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public void delete(Game game) {

        gameRepository.delete(game);
    }

    public void deleteById(Long id) {
        Game game = findById(id);
        gameRepository.delete(game);
    }


    public GameService(GameRepository gameRepository) {
        this.gameRepository =gameRepository;
    }
}
