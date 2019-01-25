package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping(value = "/all", produces = "application/json")
    public List<Game> getGames() {
        return gameRepository.findAll();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Game getGame(@PathVariable("id") Long id) {
        return gameRepository.findById(id).orElseThrow(() -> new NullPointerException());
    }

}
