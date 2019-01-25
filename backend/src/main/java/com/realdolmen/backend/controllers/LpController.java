package com.realdolmen.backend.controllers;

import com.realdolmen.backend.dao.LpDao;
import com.realdolmen.backend.model.Lp;
import com.realdolmen.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lp")
public class LpController
{
    @Autowired
    LpDao lpDao;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Lp> getAllComponents()
    {
        return lpDao.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Lp getOneForId(@PathVariable Long id)
    {
        return lpDao.getOne(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Lp save(@RequestBody @Valid Lp lp)
    {
        return lpDao.save(lp);
    }




}
