package com.realdolmen.shoprbackend.controller;

import com.realdolmen.shoprbackend.domain.Fiction;
import com.realdolmen.shoprbackend.services.FictionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fictionBooks")
public class FictionController {

    private FictionService fictionService;


    @PostMapping
    public Fiction createFiction(@RequestBody Fiction fiction){
        return fictionService.save(fiction);
    }

    @DeleteMapping
    public void deleteFiction (@RequestBody Fiction fiction){
        fictionService.delete(fiction);
    }

    @GetMapping("id")
    public Fiction findById(Long id){
        return fictionService.findById(id);
    }

    @GetMapping("")
    public List<Fiction> findAll(){
        return fictionService.findAll();
    }



    public FictionController(FictionService fictionService) {
        this.fictionService = fictionService;
    }
}
