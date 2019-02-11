package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.FictionBook;
import com.realdolmen.backend.service.FictionService;
import com.realdolmen.backend.service.FictionServiceImpl;
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
    public List<FictionBook> getFictionBooks() {
        return fictionService.findAll();
    }

    @PostMapping("/add")
    public FictionBook addFiction(@RequestBody FictionBook fiction) {
        fictionService.create(fiction);
        return fiction;
    }

    @GetMapping("/{id}")
    public FictionBook getFiction(@PathVariable("id") Long id) {
        return fictionService.findById(id);
    }


}
