package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.dto.GameDto;
import com.realdolmen.backend.facade.GameFacade;
import com.realdolmen.backend.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private GameService gameService;
    private GameFacade gameFacade;

    public GameController(GameService gameService,
                          GameFacade gameFacade) {
        this.gameService = gameService;
        this.gameFacade = gameFacade;
    }

    @GetMapping("/list")
    public List<Game> getGames() {
        return gameService.findAll();
    }

    @PostMapping("/add")
    public GameDto addGame(@RequestBody GameDto gameDto) {
        return gameFacade.create(gameDto);
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable("id") Long id) {
        return gameService.findById(id);
    }
}
