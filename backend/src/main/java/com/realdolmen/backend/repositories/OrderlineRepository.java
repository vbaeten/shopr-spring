package com.realdolmen.backend.repositories;

import com.realdolmen.backend.Domain.Orderline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "orderlines", path = "orderlines")
public interface OrderlineRepository extends JpaRepository<Orderline, Long> {
}
