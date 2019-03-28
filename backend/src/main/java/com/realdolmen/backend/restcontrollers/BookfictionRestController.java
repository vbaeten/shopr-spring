package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.Bookfiction;
import com.realdolmen.backend.domain.enums.BookfictionGenre;
import com.realdolmen.backend.dto.BookfictionDto;
import com.realdolmen.backend.mapper.BookfictionMapper;
import com.realdolmen.backend.service.BookfictionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/bookfiction")
public class BookfictionRestController {
    private final BookfictionService bookfictionService;
    private final BookfictionMapper bookfictionMapper;

    public BookfictionRestController(BookfictionService bookfictionService, BookfictionMapper bookfictionMapper) {
        this.bookfictionService = bookfictionService;
        this.bookfictionMapper = bookfictionMapper;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BookfictionDto createBookfiction(@RequestBody @Valid Bookfiction bookfiction) {
        return bookfictionMapper.convertBookfictionToDto(bookfictionService.save(bookfiction));
    }

    @GetMapping("/genres")
    public List<BookfictionGenre> getBookfictionGenres() {
        return Arrays.stream(BookfictionGenre.values()).collect(Collectors.toList());
    }

    @GetMapping(value = "/{articleId}")
    public BookfictionDto getBookFiction(@PathVariable Long articleId) {
        return bookfictionMapper.convertBookfictionToDto(bookfictionService.findById(articleId));
    }

    @PutMapping(path = "/edit")
    public void updateById(@RequestBody @Valid Bookfiction bookfiction) {
        Bookfiction existingBookfiction = bookfictionService.findById(bookfiction.getArticleId());
        bookfiction.setVersionId(existingBookfiction.getVersionId());
        bookfictionService.save(bookfiction);
    }
}
