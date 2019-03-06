package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Game;

public interface GameService extends CrudService<Game, Long>{

    Game findById(Long id);

    void delete(Game game);

}
