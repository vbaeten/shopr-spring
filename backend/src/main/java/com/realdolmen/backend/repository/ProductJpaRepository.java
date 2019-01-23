package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
}
