package com.realdolmen.backend.services;

import com.realdolmen.backend.dao.GameDao;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.model.Game;
import com.realdolmen.backend.model.User;
import com.realdolmen.backend.model.enums.UserRoleEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl
{
private GameDao gameDao;

    public GameServiceImpl(GameDao gameDao)
    {
        this.gameDao = gameDao;
    }

    public Game findById(Long id)
    {
        return gameDao.findById(id).orElseThrow(() -> new NotFoundException("game not found"));
    }

    public List<Game> findAll()
    {
        return gameDao.findAll();
    }

    public Game save(Game game)
    {
        return gameDao.save(game);
    }
}
