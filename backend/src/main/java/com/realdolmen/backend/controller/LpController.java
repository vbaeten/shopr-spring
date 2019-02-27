package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.dto.LpDto;
import com.realdolmen.backend.facade.LpFacade;
import com.realdolmen.backend.service.LpService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lp")
public class LpController {

    private LpService lpService;
    private LpFacade lpFacade;

    public LpController(LpService lpService, LpFacade lpFacade) {
        this.lpService = lpService;
        this.lpFacade = lpFacade;
    }

    @GetMapping("/list")
    public List<Lp> getLps() {
        return lpService.findAll();
    }

    @PostMapping("/add")
    public LpDto addLp(@RequestBody LpDto lpDto) {
        return lpFacade.create(lpDto);
    }

    @GetMapping("/{id}")
    public Lp getLp(@PathVariable ("id")Long id) {
        return lpService.findById(id);
    }
}
