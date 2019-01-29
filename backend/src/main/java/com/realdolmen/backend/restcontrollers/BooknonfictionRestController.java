package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.Domain.Booknonfiction;
import com.realdolmen.backend.Domain.enums.BooknonfictionGenre;
import com.realdolmen.backend.repositories.BooknonfictionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/booknonfiction")
public class BooknonfictionRestController {
    private final BooknonfictionRepository booknonfictionRepository;

    public BooknonfictionRestController(BooknonfictionRepository booknonfictionRepository) {
        this.booknonfictionRepository = booknonfictionRepository;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Booknonfiction createBooknonfiction(@RequestBody /*@Valid*/ Booknonfiction booknonfiction) {
        return booknonfictionRepository.save(booknonfiction);
    }

    @GetMapping("/genres")
    public List<BooknonfictionGenre> getBooknonfictionGenres() {
        return Arrays.stream(BooknonfictionGenre.values()).collect(Collectors.toList());
    }
}
