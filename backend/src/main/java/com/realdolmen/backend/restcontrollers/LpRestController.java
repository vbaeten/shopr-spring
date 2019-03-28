package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.domain.enums.LpGenre;
import com.realdolmen.backend.dto.LpDto;
import com.realdolmen.backend.mapper.LpMapper;
import com.realdolmen.backend.service.LpService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lp")
public class LpRestController {
    private final LpService lpService;
    private final LpMapper lpMapper;

    public LpRestController(LpService lpService, LpMapper lpMapper) {
        this.lpService = lpService;
        this.lpMapper = lpMapper;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public LpDto createLp(@RequestBody @Valid Lp lp) {
        return lpMapper.convertLpToDto(lpService.save(lp));
    }

    @GetMapping("/genres")
    public List<LpGenre> getLpGenres(){return Arrays.stream(LpGenre.values()).collect(Collectors.toList());}


    @GetMapping(value = "/{articleId}")
    public LpDto getBookFiction(@PathVariable Long articleId) {
        return lpMapper.convertLpToDto(lpService.findById(articleId));
    }

    @PutMapping(path = "/edit")
    public void updateById(@RequestBody @Valid Lp lp) {
        Lp existingGame = lpService.findById(lp.getArticleId());
        lp.setVersionId(existingGame.getVersionId());
        lpService.save(lp);
    }
}
