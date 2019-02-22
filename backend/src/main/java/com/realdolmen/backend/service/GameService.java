package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Game;

public interface GameService extends CrudService<Game, Long> {

    Game create(Game game);

    Game findById(Long articleId);
}
