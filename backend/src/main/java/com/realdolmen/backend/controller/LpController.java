package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.LpDto;
import com.realdolmen.backend.facade.LpFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lp")
public class LpController {

    private LpFacade lpFacade;

    public LpController(LpFacade lpFacade) {
        this.lpFacade = lpFacade;
    }

    @GetMapping("/list")
    public List<LpDto> getLps() {
        return lpFacade.findAll();
    }

    @PostMapping("/add")
    public LpDto addLp(@RequestBody LpDto lpDto) {
        return lpFacade.create(lpDto);
    }

    @GetMapping("/{id}")
    public LpDto getLp(@PathVariable ("id")Long id) {
        return lpFacade.findById(id);
    }
}
