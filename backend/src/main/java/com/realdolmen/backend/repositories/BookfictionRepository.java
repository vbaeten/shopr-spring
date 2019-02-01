package com.realdolmen.backend.repositories;

import com.realdolmen.backend.Domain.Bookfiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bookfiction", path = "bookfiction")
public interface BookfictionRepository extends JpaRepository<Bookfiction, Long> {
}
