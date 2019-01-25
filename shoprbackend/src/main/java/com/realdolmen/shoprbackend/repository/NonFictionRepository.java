package com.realdolmen.shoprbackend.repository;

import com.realdolmen.shoprbackend.domain.NonFiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonFictionRepository extends JpaRepository<NonFiction,Long> {
}
