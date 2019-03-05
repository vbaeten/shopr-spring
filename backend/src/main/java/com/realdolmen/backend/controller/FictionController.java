package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.service.FictionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/fiction")
public class FictionController {

    private FictionService fictionService;

    @PostMapping
    public Fiction save(@RequestBody Fiction fiction) {
        return fictionService.save(fiction);
    }

    @PutMapping("/{id}")
    public Fiction edit(@PathVariable Long id, @RequestBody Fiction fiction) {
        Fiction currentFiction = findById(id);
        if (currentFiction == null) {
            throw new NotFoundException("Article not found");
        }
        return fictionService.save(fiction);
    }

    @GetMapping("/{id}")
    public Fiction findById(@PathVariable Long id) {
        return fictionService.findById(id);
    }

    @GetMapping
    public List<Fiction> findAll() {
        return fictionService.findAll();
    }

    @DeleteMapping
    public void delete(Fiction fiction) {
        fictionService.delete(fiction);
    }

}
