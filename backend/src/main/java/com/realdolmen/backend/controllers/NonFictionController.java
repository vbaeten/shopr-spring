package com.realdolmen.backend.controllers;

import com.realdolmen.backend.dao.NonFictionDao;
import com.realdolmen.backend.model.NonFiction;
import com.realdolmen.backend.model.enums.LpGenreEnum;
import com.realdolmen.backend.model.enums.NonFictionGenreEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("nonfiction")
public class NonFictionController
{
    @Autowired
    NonFictionDao nonFictionDao;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<NonFiction> getAllComponents()
    {
        return nonFictionDao.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public NonFiction getOneForId(@PathVariable Long id)
    {
        return nonFictionDao.getOne(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public NonFiction save(@RequestBody @Valid NonFiction nonFiction)
    {
        return nonFictionDao.save(nonFiction );
    }

    @GetMapping(value = "/genre", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getGenres()
    {
        return Arrays.stream(NonFictionGenreEnum.values()).map(NonFictionGenreEnum::toString).collect(Collectors.toList());
    }

}
