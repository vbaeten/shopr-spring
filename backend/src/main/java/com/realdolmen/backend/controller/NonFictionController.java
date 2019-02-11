package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.NonFictionBook;
import com.realdolmen.backend.service.NonFictionService;
import com.realdolmen.backend.service.NonFictionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nonfiction")
public class NonFictionController {

    private NonFictionService nonFictionService;

    public NonFictionController(NonFictionServiceImpl nonFictionService) {
        this.nonFictionService = nonFictionService;
    }

    @GetMapping("/list")
    public List<NonFictionBook> getNonFictionBooks() {
        return nonFictionService.findAll();
    }

    @PostMapping("/add")
    public NonFictionBook addNonFiction(@RequestBody NonFictionBook nonFictionBook) {
        nonFictionService.create(nonFictionBook);
        return nonFictionBook;
    }

    @GetMapping("/{id}")
    public NonFictionBook getNonFiction(@PathVariable("id") Long id) {
        return nonFictionService.findById(id);
    }

}
