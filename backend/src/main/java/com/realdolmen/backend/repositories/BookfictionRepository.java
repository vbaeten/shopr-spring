package com.realdolmen.backend.repositories;

import com.realdolmen.backend.Domain.Bookfiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookfictionRepository extends JpaRepository<Bookfiction, Long> {
}
