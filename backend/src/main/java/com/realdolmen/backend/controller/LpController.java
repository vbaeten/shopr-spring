package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.service.LpServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lp")
public class LpController {

    private LpServiceImpl lpServiceImpl;

    public LpController(LpServiceImpl lpServiceImpl) {
        this.lpServiceImpl = lpServiceImpl;
    }

    @GetMapping("/list")
    public List<Lp> getLps() {
        return lpServiceImpl.findAll();
    }

    @PostMapping("/add")
    public Lp addLp(@RequestBody Lp lp) {
        return lpServiceImpl.create(lp);
    }
}
