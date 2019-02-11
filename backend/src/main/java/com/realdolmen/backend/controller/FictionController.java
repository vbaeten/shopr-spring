package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.service.FictionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard/fictions")
public class FictionController {

    private final FictionService fictionService;

    public FictionController(FictionService fictionService) {
        this.fictionService = fictionService;
    }

    @GetMapping(value = "/all")
    public List<Fiction> getFictions() {
        return fictionService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Fiction getFiction(@PathVariable(value = "id") Long id) {
        return fictionService.findById(id);
    }

    @PostMapping(value = "/add")
    public Fiction newFiction(Fiction fiction) {
        return fictionService.save(fiction);
    }

    @DeleteMapping(value = "/remove")
    public void deleteFiction(Fiction fiction) {
        fictionService.delete(fiction);
    }
}
