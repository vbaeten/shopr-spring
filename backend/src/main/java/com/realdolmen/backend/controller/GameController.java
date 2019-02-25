package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
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

    @GetMapping("/{id}")
    public Game getGame(@PathVariable("id") Long id) {
        return gameService.findById(id);
    }
}
