package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

     @Autowired
    private BookJpaRepository bookJpaRepository;

     public Book create(Book book) {
         return bookJpaRepository.saveAndFlush(book);
     }

     public void delete(Book book) {
         bookJpaRepository.delete(book);
     }

     public Optional<Book> findById(Long id) {
         return bookJpaRepository.findById(id);
     }

     public List<Book> findAll() {
         return bookJpaRepository.findAll();
     }
}
