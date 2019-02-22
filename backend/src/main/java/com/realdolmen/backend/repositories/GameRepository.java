package com.realdolmen.backend.repositories;

import com.realdolmen.backend.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "game", path = "game")
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game>findGameByTitle(String title);

}
