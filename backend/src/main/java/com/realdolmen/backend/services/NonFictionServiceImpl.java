package com.realdolmen.backend.services;

import com.realdolmen.backend.dao.NonFictionDao;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.model.NonFiction;
import com.realdolmen.backend.model.enums.NonFictionGenreEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonFictionServiceImpl
{

    private NonFictionDao nonFictionDao;

    public NonFictionServiceImpl(NonFictionDao nonFictionDao)
    {
        this.nonFictionDao = nonFictionDao;
    }

    public NonFiction findById(Long id)
    {
        return nonFictionDao.findById(id).orElseThrow(() -> new NotFoundException("book not found"));
    }

    public List<NonFiction> findAll()
    {
        return nonFictionDao.findAll();
    }

    public NonFiction save(NonFiction nonFiction)
    {
        switch (nonFiction.getGenre())
        {

            case "religion":
                nonFiction.setNonFictionGenreEnum(NonFictionGenreEnum.RELIGION);
                break;
            case "biography":
               nonFiction.setNonFictionGenreEnum(NonFictionGenreEnum.BIOGRAPHY);
                break;
            case "food":
                nonFiction.setNonFictionGenreEnum(NonFictionGenreEnum.FOOD);
                break;
            case "travel":
               nonFiction.setNonFictionGenreEnum(NonFictionGenreEnum.TRAVEL);
                break;

        }

        return nonFictionDao.save(nonFiction);
    }
}
