package com.realdolmen.backend.controllers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.realdolmen.backend.model.Lp;
import com.realdolmen.backend.model.enums.LpGenreEnum;
import com.realdolmen.backend.services.LpServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lp")
public class LpController
{
    private LpServiceImpl lpService;

    public LpController(LpServiceImpl lpService)
    {
        this.lpService = lpService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Lp> getAllComponents()
    {
        return lpService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Lp getOneForId(@PathVariable Long id)
    {
        return lpService.findById(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)

    public Lp save(@RequestBody @Valid Lp lp)
    {
        return lpService.save(lp);
    }

    @GetMapping(value = "/genre", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getGenres()
    {
        return Arrays.stream(LpGenreEnum.values()).map(LpGenreEnum::toString).collect(Collectors.toList());
    }


}
