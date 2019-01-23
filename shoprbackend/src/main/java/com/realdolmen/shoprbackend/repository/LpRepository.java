package com.realdolmen.shoprbackend.repository;

import com.realdolmen.shoprbackend.domain.Lp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LpRepository extends JpaRepository<Lp,Long> {

}
