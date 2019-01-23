package com.realdolmen.backend.controllers;

import com.realdolmen.backend.dao.FictionDao;
import com.realdolmen.backend.model.Fiction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fiction")
public class FictionController
{
@Autowired
    FictionDao fictionDao;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Fiction> getAllComponents()
    {
        return fictionDao.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Fiction getOneForId(@PathVariable Long id)
    {
        return fictionDao.getOne(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Fiction save(@RequestBody @Valid Fiction fiction)
    {
        return fictionDao.save( fiction);
    }


}
