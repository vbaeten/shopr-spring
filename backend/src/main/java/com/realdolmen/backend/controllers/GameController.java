package com.realdolmen.backend.controllers;

import com.realdolmen.backend.dao.GameDao;
import com.realdolmen.backend.model.Game;
import com.realdolmen.backend.model.enums.GameGenreEnum;
import com.realdolmen.backend.services.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/game")
public class GameController
{

    private GameServiceImpl gameService;
    Game game;

    public GameController(GameServiceImpl gameService)
    {
        this.gameService = gameService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllComponents()
    {
        return gameService.findAll();
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Game getOneForId(@PathVariable Long id)
    {
        game = new Game();
        game =  gameService.findById(id);
        game.setGenre(game.getGameGenreEnum().toString());
        return game;

    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Game save(@RequestBody  Game game)
    {
        return gameService.save(game);
    }

    @GetMapping(value = "/genre", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getGenres()
    {
        return Arrays.stream(GameGenreEnum.values()).map(GameGenreEnum::toString).collect(Collectors.toList());
    }


}
