package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.service.FictionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fiction")
public class FictionController {

    private FictionService fictionService;

    public FictionController(FictionService fictionService) {
        this.fictionService = fictionService;
    }

    @GetMapping("/list")
    public List<Fiction> getFictionBooks() {
        return fictionService.findAll();
    }

    @PostMapping("/add")
    public Fiction addFiction(@RequestBody Fiction fiction) {
        fictionService.create(fiction);
        return fiction;
    }

    @GetMapping("/{id}")
    public Fiction getFiction(@PathVariable("id") Long id) {
        return fictionService.findById(id);
    }

}
