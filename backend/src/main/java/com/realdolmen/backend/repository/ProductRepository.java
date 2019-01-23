package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    public Product create(Product product) {
        return productJpaRepository.saveAndFlush(product);
    }

    public void delete(Product product) {
        productJpaRepository.delete(product);
    }

    public Optional<Product> findById(Long id) {
        return productJpaRepository.findById(id);
    }

    public List<Product> findAll() {
        return productJpaRepository.findAll();
    }
}
