package com.realdolmen.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    @Override
    public List<Book> findAll() {
        return null;
    }

}
