package com.realdolmen.shoprbackend.controller;

import com.realdolmen.shoprbackend.domain.Fiction;
import com.realdolmen.shoprbackend.services.FictionService;
import org.springframework.http.HttpStatus;
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

    @DeleteMapping(value ="/{id}")
    public void deleteById (@PathVariable("id")Long id){
        fictionService.deleteById(id);
    }



    @GetMapping("/{id}")
    public Fiction findById(@PathVariable Long id){
        return fictionService.findById(id);
    }



    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Fiction> findAll(){
        return fictionService.findAll();
    }


    

    public FictionController(FictionService fictionService) {
        this.fictionService = fictionService;
    }
}
