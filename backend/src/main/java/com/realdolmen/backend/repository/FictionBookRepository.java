package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.FictionBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FictionBookRepository extends JpaRepository<FictionBook, Long> {
}
