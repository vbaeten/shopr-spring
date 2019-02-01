package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.FictionBook;
import com.realdolmen.backend.service.FictionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fiction")
public class FictionController {

    private FictionServiceImpl fictionServiceImpl;

    public FictionController(FictionServiceImpl fictionServiceImpl) {
        this.fictionServiceImpl = fictionServiceImpl;
    }

    @GetMapping("/list")
    public List<FictionBook> getFictionBooks() {
        return fictionServiceImpl.findAll();
    }

    @PostMapping("/add")
    public FictionBook addFiction(@RequestBody FictionBook fictionBook) {
        return fictionServiceImpl.create(fictionBook);
    }


}
