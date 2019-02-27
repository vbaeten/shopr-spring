package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.FictionDto;
import com.realdolmen.backend.facade.FictionFacade;
import com.realdolmen.backend.service.FictionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fiction")
public class FictionController {

    private FictionFacade fictionFacade;

    public FictionController(FictionService fictionService, FictionFacade fictionFacade) {
        this.fictionFacade = fictionFacade;
    }

    @GetMapping("/list")
    public List<FictionDto> getFictionBooks() {
        return fictionFacade.findAll();
    }

    @PostMapping("/add")
    public FictionDto addFiction(@RequestBody FictionDto fictionDto) {
        return fictionFacade.create(fictionDto);
    }

    @GetMapping("/{id}")
    public FictionDto getFiction(@PathVariable("id") Long id) {
        return fictionFacade.findById(id);
    }

}
