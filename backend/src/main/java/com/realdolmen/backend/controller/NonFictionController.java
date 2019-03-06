package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.NonFictionDto;
import com.realdolmen.backend.facade.NonFictionFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nonfiction")
public class NonFictionController {

    private NonFictionFacade nonFictionFacade;

    public NonFictionController(NonFictionFacade nonFictionFacade) {
        this.nonFictionFacade = nonFictionFacade;
    }

    @GetMapping("/list")
    public List<NonFictionDto> getNonFictionBooks() {
        return nonFictionFacade.findAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public NonFictionDto addNonFictionDto(@RequestBody NonFictionDto nonFictionDto) {
        return nonFictionFacade.create(nonFictionDto);
    }

    @GetMapping("/{id}")
    public NonFictionDto getNonFiction(@PathVariable("id") Long id) {
        return nonFictionFacade.findById(id);
    }

}
