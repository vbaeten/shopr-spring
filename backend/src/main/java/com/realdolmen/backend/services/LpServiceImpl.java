package com.realdolmen.backend.services;

import com.realdolmen.backend.dao.LpDao;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.model.Lp;
import com.realdolmen.backend.model.enums.LpGenreEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LpServiceImpl
{
    private LpDao lpDao;

    public LpServiceImpl(LpDao lpDao)
    {
        this.lpDao = lpDao;
    }

    public Lp findById(Long id)
    {
        return lpDao.findById(id).orElseThrow(() -> new NotFoundException("lp not found"));
    }

    public List<Lp> findAll()
    {
        return lpDao.findAll();
    }

    public Lp save(Lp lp)
    {
        switch (lp.getGenre())
        {

            case "metal":
                lp.setLpGenreEnum(LpGenreEnum.METAL);
                break;
            case "rock":
                lp.setLpGenreEnum(LpGenreEnum.ROCK);
                break;
            case "dance":
                lp.setLpGenreEnum(LpGenreEnum.DANCE);
                break;
            case "classic":
                lp.setLpGenreEnum(LpGenreEnum.CLASSIC);
                break;
            case "folk":
                lp.setLpGenreEnum(LpGenreEnum.FOLK);
                break;
            case "pop":
                lp.setLpGenreEnum(LpGenreEnum.POP);
                break;
        }
        return lpDao.save(lp);
    }
}
