package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/all", produces = "application/json")
    public List<Game> getGames() {
        return gameService.findAll();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Game getGame(@PathVariable("id") Long id) {
        return gameService.findById(id);
    }

    @PostMapping(value = "/new")
    public Game newGame(Game game) {
        return gameService.save(game);
    }

}
