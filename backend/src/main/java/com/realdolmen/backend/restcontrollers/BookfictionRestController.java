package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.Bookfiction;
import com.realdolmen.backend.domain.enums.BookfictionGenre;
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

    public BookfictionRestController(BookfictionService bookfictionService) {
        this.bookfictionService = bookfictionService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Bookfiction createBookfiction(@RequestBody @Valid Bookfiction bookfiction) {
        return bookfictionService.save(bookfiction);
    }

    @GetMapping("/genres")
    public List<BookfictionGenre> getBookfictionGenres() {
        return Arrays.stream(BookfictionGenre.values()).collect(Collectors.toList());
    }

    @GetMapping(value = "/{articleId}")
    public Bookfiction getBookFiction(@PathVariable Long articleId) {
        return bookfictionService.findById(articleId);
    }

    @PutMapping(path = "/edit")
    public void updateById(@RequestBody @Valid Bookfiction bookfiction) {
        Bookfiction existingBookfiction = bookfictionService.findById(bookfiction.getArticleId());
        bookfiction.setVersionId(existingBookfiction.getVersionId());
        bookfictionService.save(bookfiction);
    }
}
