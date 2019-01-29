package com.realdolmen.shoprbackend.controller;

import com.realdolmen.shoprbackend.domain.Game;
import com.realdolmen.shoprbackend.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

   private  GameService gameService;


   //get data ophalen
    //post data aanmaken
    //put data updaten
    //delete voor DUH


    @PostMapping
    public Game saveGame(@RequestBody Game game){
        gameService.save(game);
        return game;
    }

    @GetMapping("/{id}")
    public Game findById(@PathVariable Long id){
        return gameService.findById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> findAll(){
        return gameService.findAll();
    }

    @DeleteMapping(value ="/{id}")
    public void deleteById(@PathVariable("id") Long id){
        gameService.deleteById(id);
    }


    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

}
