package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.dto.FictionDto;
import com.realdolmen.backend.facade.FictionFacade;
import com.realdolmen.backend.service.FictionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fiction")
public class FictionController {

    private FictionService fictionService;
    private FictionFacade fictionFacade;

    public FictionController(FictionService fictionService, FictionFacade fictionFacade) {
        this.fictionService = fictionService;
        this.fictionFacade = fictionFacade;
    }

    @GetMapping("/list")
    public List<Fiction> getFictionBooks() {
        return fictionService.findAll();
    }

    @PostMapping("/add")
    public FictionDto addFiction(@RequestBody FictionDto fictionDto) {
        return fictionFacade.create(fictionDto);
    }

    @GetMapping("/{id}")
    public Fiction getFiction(@PathVariable("id") Long id) {
        return fictionService.findById(id);
    }

}
