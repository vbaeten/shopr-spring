package com.realdolmen.shoprbackend.repository;

import com.realdolmen.shoprbackend.domain.Fiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FictionRepository extends JpaRepository<Fiction,Long> {
}
