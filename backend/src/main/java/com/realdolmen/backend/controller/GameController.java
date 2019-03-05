package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/game")
public class GameController {

    private final GameService gameService;

    @PostMapping
    public Game save(@RequestBody Game game) {
        return gameService.save(game);
    }

    @PutMapping("/{id}")
    public Game edit(@PathVariable Long id, @RequestBody Game game) {
        Game currentGame = findById(id);
        if (currentGame == null) {
            throw new NotFoundException("Article not found");
        }
        return gameService.save(game);
    }

    @GetMapping("/{id}")
    public Game findById(@PathVariable Long id) {
        return gameService.findById(id);
    }

    @GetMapping
    public List<Game> findAll() {
        return gameService.findAll();
    }

    @DeleteMapping
    public void delete(Game game) {
        gameService.delete(game);
    }

}
