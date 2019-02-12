package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.service.NonFictionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/nonFiction")
public class NonFictionController {

    private NonFictionService nonFictionService;

    @PostMapping
    public NonFiction save(@RequestBody NonFiction nonFiction) {
        return nonFictionService.save(nonFiction);
    }

    @GetMapping("/{id}")
    public NonFiction findById(@PathVariable Long id) {
        return nonFictionService.findById(id);
    }

    @GetMapping
    public List<NonFiction> findAll(){
        return nonFictionService.findAll();
    }

    @DeleteMapping
    public void delete(NonFiction nonFiction) {
        nonFictionService.delete(nonFiction);
    }

}
