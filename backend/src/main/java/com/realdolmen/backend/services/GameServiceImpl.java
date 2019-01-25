package com.realdolmen.backend.services;

import com.realdolmen.backend.dao.GameDao;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.model.Game;
import com.realdolmen.backend.model.enums.GameGenreEnum;
import com.realdolmen.backend.model.enums.LpGenreEnum;
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
        switch (game.getGenre())
        {

            case "fps":
                game.setGameGenreEnum(GameGenreEnum.FPS);
                break;
            case "rts":
                game.setGameGenreEnum(GameGenreEnum.RTS);
                break;
            case "tps":
                game.setGameGenreEnum(GameGenreEnum.TPS);
                break;
            case "mobile":
                game.setGameGenreEnum(GameGenreEnum.MOBILE);
                break;
            case "mmorpg":
                game.setGameGenreEnum(GameGenreEnum.MMORPG);
                break;
            case "rpg":
                game.setGameGenreEnum(GameGenreEnum.RPG);
                break;
        }
        return gameDao.save(game);
    }
}
