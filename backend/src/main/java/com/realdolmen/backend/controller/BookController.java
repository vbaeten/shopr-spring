package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Book;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<String> checkIfIsbnExists(@PathVariable("isbn") String isbn) {
        try {
            Book book = bookService.findByIsbn(isbn);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(isbn);
        } catch (Exception e) {
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("/{id}")
    public Book getBookByArticleId(@PathVariable("id")  Long id) throws NotFoundException {
        return bookService.findById(id);
    }


    @GetMapping("/{isbn}/{id}")
    public ResponseEntity<String> checkIfIsbnExistsForEdit(@PathVariable("isbn") String isbn,@PathVariable("id") Long id) throws NotFoundException {
            Book currentBook = bookService.findById(id);
            if (currentBook.getIsbn().equals(isbn)) {
                return ResponseEntity.ok().build();
            } else {
                try {
                    bookService.findByIsbn(isbn);
                    return ResponseEntity.status(HttpStatus.CONFLICT).body(isbn);
                } catch (Exception e) {
                    return ResponseEntity.ok().build();
                }
            }
    }

}
