package com.realdolmen.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realdolmen.backend.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
