package com.realdolmen.backend.repositories;

import com.realdolmen.backend.domain.Lp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "lp", path = "lp")
public interface LpRepository extends JpaRepository<Lp, Long> {
}
