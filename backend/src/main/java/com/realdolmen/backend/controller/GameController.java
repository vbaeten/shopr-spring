package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.service.GameServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private GameServiceImpl gameServiceImpl;

    public GameController(GameServiceImpl gameServiceImpl) {
        this.gameServiceImpl = gameServiceImpl;
    }

    @GetMapping("/list")
    public List<Game> getGames() {
        return gameServiceImpl.findAll();
    }

    @PostMapping("/add")
    public Game addGame(@RequestBody Game game) {
        return gameServiceImpl.create(game);
    }

    @DeleteMapping("/delete")
    public void deleteGame(Game game) {
        gameServiceImpl.delete(game);
    }
}
