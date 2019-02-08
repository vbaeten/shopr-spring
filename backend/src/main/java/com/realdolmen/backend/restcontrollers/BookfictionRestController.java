package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.Domain.Bookfiction;
import com.realdolmen.backend.Domain.enums.BookfictionGenre;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repositories.BookfictionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/bookfiction")
public class BookfictionRestController {
    private final BookfictionRepository bookfictionRepository;

    public BookfictionRestController(BookfictionRepository bookfictionRepository) {
        this.bookfictionRepository = bookfictionRepository;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Bookfiction createBookfiction(@RequestBody Bookfiction bookfiction) {
        return bookfictionRepository.save(bookfiction);
    }

    @GetMapping("/genres")
    public List<BookfictionGenre> getBookfictionGenres() {
        return Arrays.stream(BookfictionGenre.values()).collect(Collectors.toList());
    }

    @GetMapping(value = "/{articleId}")
    public Bookfiction getBookFiction(@PathVariable Long articleId) {
        return bookfictionRepository.findById(articleId)
                .orElseThrow(NotFoundException::new);
    }

    @PutMapping(path = "/edit")
    public void updateById(@RequestBody Bookfiction bookfiction) {
        Bookfiction existingBookfiction = bookfictionRepository.findById(bookfiction.getArticleId())
                .orElseThrow(NotFoundException::new);
        bookfiction.setVersionId(existingBookfiction.getVersionId());
        bookfictionRepository.save(bookfiction);
    }
}
