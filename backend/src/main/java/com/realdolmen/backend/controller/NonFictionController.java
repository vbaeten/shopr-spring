package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.NonFictionBook;
import com.realdolmen.backend.service.NonFictionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nonfiction")
public class NonFictionController {

    private NonFictionServiceImpl nonFictionServiceImpl;

    public NonFictionController(NonFictionServiceImpl nonFictionServiceImpl) {
        this.nonFictionServiceImpl = nonFictionServiceImpl;
    }

    @GetMapping("/list")
    public List<NonFictionBook> getNonFictionBooks() {
        return nonFictionServiceImpl.findAll();
    }

    @PostMapping("/add")
    public NonFictionBook addNonFiction(@RequestBody NonFictionBook nonFictionBook) {
        return nonFictionServiceImpl.create(nonFictionBook);
    }

}
