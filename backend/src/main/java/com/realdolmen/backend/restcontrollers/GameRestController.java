package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.Domain.Game;
import com.realdolmen.backend.Domain.enums.GameGenre;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repositories.GameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/game")
public class GameRestController {
    private final GameRepository gameRepository;

    public GameRestController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody /*@Valid*/ Game game){
        return gameRepository.save(game);
    }

    @GetMapping("/genres")
    public List<GameGenre> getGameGenres(){return Arrays.stream(GameGenre.values()).collect(Collectors.toList());}


    @GetMapping(value = "/{articleId}")
    public Game getBookFiction(@PathVariable Long articleId) {
        return gameRepository.findById(articleId)
                .orElseThrow(NotFoundException::new);
    }

    @PutMapping(path = "/edit")
    public void updateById(@RequestBody Game game) {
        Game existingGame = gameRepository.findById(game.getArticleId())
                .orElseThrow(NotFoundException::new);
        game.setVersionId(existingGame.getVersionId());
        gameRepository.save(game);
    }
}
