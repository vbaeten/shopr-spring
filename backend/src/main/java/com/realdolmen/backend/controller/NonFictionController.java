package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.dto.NonFictionDto;
import com.realdolmen.backend.facade.NonFictionFacade;
import com.realdolmen.backend.service.NonFictionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nonfiction")
public class NonFictionController {

    private NonFictionService nonFictionService;
    private NonFictionFacade nonFictionFacade;

    public NonFictionController(NonFictionService nonFictionService) {
        this.nonFictionService = nonFictionService;
    }

    @GetMapping("/list")
    public List<NonFiction> getNonFictionBooks() {
        return nonFictionService.findAll();
    }

    @PostMapping("/add")
    public NonFictionDto addNonFictionDto(@RequestBody NonFictionDto nonFictionDto) {
        return nonFictionFacade.create(nonFictionDto);
    }

    @GetMapping("/{id}")
    public NonFiction getNonFiction(@PathVariable("id") Long id) {
        return nonFictionService.findById(id);
    }

}
