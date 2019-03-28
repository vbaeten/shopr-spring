package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.Booknonfiction;
import com.realdolmen.backend.domain.enums.BooknonfictionGenre;
import com.realdolmen.backend.dto.BooknonfictionDto;
import com.realdolmen.backend.mapper.BooknonfictionMapper;
import com.realdolmen.backend.service.BooknonfictionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/booknonfiction")
public class BooknonfictionRestController {
    private final BooknonfictionService booknonfictionService;
    private final BooknonfictionMapper booknonfictionMapper;

    public BooknonfictionRestController(BooknonfictionService booknonfictionService, BooknonfictionMapper booknonfictionMapper) {
        this.booknonfictionService = booknonfictionService;
        this.booknonfictionMapper = booknonfictionMapper;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BooknonfictionDto createBooknonfiction(@RequestBody @Valid Booknonfiction booknonfiction) {
        return booknonfictionMapper.convertBooknonfictionToDto(booknonfictionService.save(booknonfiction));
    }

    @GetMapping("/genres")
    public List<BooknonfictionGenre> getBooknonfictionGenres() {
        return Arrays.stream(BooknonfictionGenre.values()).collect(Collectors.toList());
    }

    @GetMapping(value = "/{articleId}")
    public BooknonfictionDto getBookFiction(@PathVariable Long articleId) {
        return booknonfictionMapper.convertBooknonfictionToDto(booknonfictionService.findById(articleId));
    }

    @PutMapping(path = "/edit")
    public void updateById(@RequestBody @Valid Booknonfiction booknonfiction) {
        Booknonfiction existingBooknonfiction = booknonfictionService.findById(booknonfiction.getArticleId());
        booknonfiction.setVersionId(existingBooknonfiction.getVersionId());
        booknonfictionService.save(booknonfiction);
    }
}