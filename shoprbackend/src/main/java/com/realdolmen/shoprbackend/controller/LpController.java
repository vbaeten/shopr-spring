package com.realdolmen.shoprbackend.controller;

import com.realdolmen.shoprbackend.domain.Lp;
import com.realdolmen.shoprbackend.services.LpService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lps")
public class LpController {


    private LpService lpService;


    @PostMapping
    public Lp createLp(@RequestBody Lp lp){
         lpService.save(lp);
         return lp;
    }

    @DeleteMapping
    public void deleteLp(@RequestBody Lp lp){
        lpService.delete(lp);
    }

    @GetMapping("/id")
    public Lp findById(Long id){
        return lpService.findById(id);
    }

    @GetMapping("")
    public List<Lp> findAll(){
        return lpService.findAll();
    }


    public LpController(LpService lpService) {
        this.lpService = lpService;
    }
}
