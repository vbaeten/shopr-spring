package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Book;
import com.realdolmen.backend.exceptions.NotFoundException;

import java.util.List;

public interface BookService extends CrudService<Book, Long> {

    List<Book> findAll();

    Book findByIsbn(String isbn) throws NotFoundException;

}
