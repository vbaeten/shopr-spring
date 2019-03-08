package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Book;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new NotFoundException("Book not found"));
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

}
