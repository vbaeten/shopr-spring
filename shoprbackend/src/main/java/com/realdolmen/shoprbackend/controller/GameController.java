package com.realdolmen.shoprbackend.controller;

import com.realdolmen.shoprbackend.domain.Game;
import com.realdolmen.shoprbackend.services.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/game")
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

    @GetMapping
    public Game findById(Long id){
        return gameService.findById(id);
    }

    @GetMapping
    public List<Game> findAll(){
        return gameService.findAll();
    }

    @DeleteMapping
    public void delete(@RequestBody Game game){
        gameService.delete(game);
    }


    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

}
