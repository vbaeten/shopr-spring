package com.realdolmen.backend.repositories;

import com.realdolmen.backend.Domain.Orderline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "orderline", path = "orderline")
public interface OrderlineRepo extends JpaRepository<Orderline, Long> {
}
