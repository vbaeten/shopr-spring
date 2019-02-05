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

    @DeleteMapping(value ="/{id}")
    public void deleteById (@PathVariable Long id){
        nonFictionService.deleteById(id);
    }

    @GetMapping("/{id}")
    public NonFiction findById(@PathVariable Long id){
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
