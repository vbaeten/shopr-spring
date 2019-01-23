package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
}
