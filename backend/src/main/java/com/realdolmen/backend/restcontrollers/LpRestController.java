package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.domain.enums.LpGenre;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repositories.LpRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Lp createLp(@RequestBody @Valid Lp lp) {
        return lpRepository.save(lp);
    }

    @GetMapping("/genres")
    public List<LpGenre> getLpGenres(){return Arrays.stream(LpGenre.values()).collect(Collectors.toList());}


    @GetMapping(value = "/{articleId}")
    public Lp getBookFiction(@PathVariable Long articleId) {
        return lpRepository.findById(articleId)
                .orElseThrow(NotFoundException::new);
    }

    @PutMapping(path = "/edit")
    public void updateById(@RequestBody @Valid Lp lp) {
        Lp existingLp = lpRepository.findById(lp.getArticleId())
                .orElseThrow(NotFoundException::new);
        lp.setVersionId(existingLp.getVersionId());
        lpRepository.save(lp);
    }
}
