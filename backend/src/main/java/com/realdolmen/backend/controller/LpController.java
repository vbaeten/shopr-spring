package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.service.LpService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lp")
public class LpController {

    private LpService lpService;

    public LpController(LpService lpService) {
        this.lpService = lpService;
    }

    @GetMapping("/list")
    public List<Lp> getLps() {
        return lpService.findAll();
    }

    @PostMapping("/add")
    public Lp addLp(@RequestBody Lp lp) {
        lpService.create(lp);
        return lp;
    }

    @GetMapping("/{id}")
    public Lp getLp(@PathVariable ("id")Long id) {
        return lpService.findById(id);
    }
}
