package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.GameDto;
import com.realdolmen.backend.facade.GameFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private GameFacade gameFacade;

    public GameController(GameFacade gameFacade) {
        this.gameFacade = gameFacade;
    }

    @GetMapping("/list")
    public List<GameDto> getGames() {
        return gameFacade.findAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public GameDto addGame(@RequestBody GameDto gameDto) {
        return gameFacade.create(gameDto);
    }

    @GetMapping("/{id}")
    public GameDto getGame(@PathVariable("id") Long id) {
        return gameFacade.findById(id);
    }
}
