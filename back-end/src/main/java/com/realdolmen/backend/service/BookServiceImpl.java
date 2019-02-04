package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Book;
import com.realdolmen.backend.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl extends CrudServiceImpl<Book, Long> implements BookService {
    private final BookRepository bookRepository;

    @Override
    protected JpaRepository<Book, Long> getRepository() {
        return bookRepository;
    }
}
