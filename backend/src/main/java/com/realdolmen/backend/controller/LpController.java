package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.service.LpService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/lp")
public class LpController {

    private LpService lpService;

    @PostMapping
    public Lp save(@RequestBody Lp lp) {
        return lpService.save(lp);
    }

    @PutMapping("/{id}")
    public Lp edit(@PathVariable Long id, @RequestBody Lp lp) {
        Lp currentLp = findById(id);
        if (currentLp == null) {
            throw new NotFoundException("Article not found");
        }
        return lpService.save(lp);
    }

    @GetMapping("/{id}")
    public Lp findById(@PathVariable Long id) {
        return lpService.findById(id);
    }

    @GetMapping
    public List<Lp> findAll() {
        return lpService.findAll();
    }

    @DeleteMapping
    public void delete(Lp lp) {
        lpService.delete(lp);
    }

}
