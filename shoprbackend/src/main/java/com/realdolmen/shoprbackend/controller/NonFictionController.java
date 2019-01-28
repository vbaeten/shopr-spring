package com.realdolmen.shoprbackend.controller;

import com.realdolmen.shoprbackend.domain.NonFiction;
import com.realdolmen.shoprbackend.services.NonFictionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nonFictionBooks")
public class NonFictionController {


    private NonFictionService nonFictionService;



    @PostMapping
    public NonFiction createNonFiction(@RequestBody NonFiction nonFiction){
        return nonFictionService.save(nonFiction);
    }

    @DeleteMapping
    public void deleteNonFiction(@RequestBody NonFiction nonFiction){
        nonFictionService.delete(nonFiction);
    }

    @GetMapping("/id")
    public NonFiction findById(Long id){
        return nonFictionService.findById(id);
    }

    @GetMapping("/all")
    public List<NonFiction> findAll(){
        return nonFictionService.findAll();
    }



    public NonFictionController(NonFictionService nonFictionService) {
        this.nonFictionService = nonFictionService;
    }
}
