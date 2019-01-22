package com.realdolmen.backend.repositories;

import com.realdolmen.backend.Domain.Lp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LpRepository extends JpaRepository<Lp, Long> {
}
