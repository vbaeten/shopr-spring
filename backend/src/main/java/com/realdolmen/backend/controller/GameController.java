package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.service.GameService;
import com.realdolmen.backend.service.GameServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private GameService gameService;

    public GameController(GameServiceImpl gameServiceImpl) {
        this.gameService = gameServiceImpl;
    }

    @GetMapping("/list")
    public List<Game> getGames() {
        return gameService.findAll();
    }

    @PostMapping("/add")
    public Game addGame(@RequestBody Game game) {
        gameService.create(game);
        return game;
    }

    @DeleteMapping("/delete")
    public void deleteGame(Game game) {
        gameService.delete(game);
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable("id") Long id) {
        return gameService.findById(id);
    }
}
