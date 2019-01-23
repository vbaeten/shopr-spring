package com.realdolmen.backend.controllers;

import com.realdolmen.backend.dao.FictionDao;
import com.realdolmen.backend.dao.RatingDao;
import com.realdolmen.backend.model.Fiction;
import com.realdolmen.backend.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController
{
    @Autowired
    RatingDao ratingDao;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Rating> getAllComponents()
    {
        return ratingDao.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Rating getOneForId(@PathVariable Long id)
    {
        return ratingDao.getOne(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Rating save(@RequestBody @Valid Rating rating)
    {
        return ratingDao.save( rating);
    }

}
