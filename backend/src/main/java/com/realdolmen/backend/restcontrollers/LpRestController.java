package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.Domain.Lp;
import com.realdolmen.backend.Domain.enums.LpGenre;
import com.realdolmen.backend.repositories.LpRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lp")
public class LpRestController {
    private final LpRepository lpRepository;

    public LpRestController(LpRepository lpRepository) {
        this.lpRepository = lpRepository;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Lp createLp(@RequestBody /*@Valid*/ Lp lp){
        return lpRepository.save(lp);
    }

    @GetMapping("/genres")
    public List<LpGenre> getLpGenres(){return Arrays.stream(LpGenre.values()).collect(Collectors.toList());}
}
