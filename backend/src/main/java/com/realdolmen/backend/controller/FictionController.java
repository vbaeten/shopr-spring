package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.FictionDto;
import com.realdolmen.backend.facade.FictionFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fiction")
public class FictionController {

    private FictionFacade fictionFacade;

    public FictionController(FictionFacade fictionFacade) {
        this.fictionFacade = fictionFacade;
    }

    @GetMapping("/list")
    public List<FictionDto> getFictionBooks() {
        return fictionFacade.findAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public FictionDto addFiction(@RequestBody FictionDto fictionDto) {
        return fictionFacade.create(fictionDto);
    }

    @GetMapping("/{id}")
    public FictionDto getFiction(@PathVariable("id") Long id) {
        return fictionFacade.findById(id);
    }

}
