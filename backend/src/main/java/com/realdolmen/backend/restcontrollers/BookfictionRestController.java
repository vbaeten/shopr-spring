package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.Domain.Bookfiction;
import com.realdolmen.backend.Domain.enums.BookfictionGenre;
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
    public Bookfiction createBookfiction(@RequestBody /*@Valid*/ Bookfiction bookfiction) {
        return bookfictionRepository.save(bookfiction);
    }

    @GetMapping("/genres")
    public List<BookfictionGenre> getBookfictionGenres() {
        return Arrays.stream(BookfictionGenre.values()).collect(Collectors.toList());
    }
}
