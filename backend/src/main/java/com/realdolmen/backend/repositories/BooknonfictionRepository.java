package com.realdolmen.backend.repositories;

import com.realdolmen.backend.Domain.Booknonfiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooknonfictionRepository extends JpaRepository<Booknonfiction, Long> {
}
