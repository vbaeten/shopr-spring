package com.realdolmen.backend.dao;

import com.realdolmen.backend.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDao extends JpaRepository<Game, Long>
{


}
