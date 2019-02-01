package com.realdolmen.backend.repositories;

import com.realdolmen.backend.Domain.Booknonfiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "booknonfiction", path = "booknonfiction")
public interface BooknonfictionRepository extends JpaRepository<Booknonfiction, Long> {
}
