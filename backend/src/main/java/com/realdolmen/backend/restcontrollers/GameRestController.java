package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.domain.enums.GameGenre;
import com.realdolmen.backend.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/game")
public class GameRestController {
    private final GameService gameService;

    public GameRestController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game) {
        return gameService.save(game);
    }

    @GetMapping("/genres")
    public List<GameGenre> getGameGenres() {
        return Arrays.stream(GameGenre.values()).collect(Collectors.toList());
    }

    @GetMapping(value = "/{articleId}")
    public Game getBookFiction(@PathVariable Long articleId) {
        return gameService.findById(articleId);
    }

    @PutMapping(path = "/edit")
    public void updateById(@RequestBody @Valid Game game) {
        Game existingGame = gameService.findById(game.getArticleId());
        game.setVersionId(existingGame.getVersionId());
        gameService.save(game);
    }
}
