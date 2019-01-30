package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Product;
import com.realdolmen.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.saveAndFlush(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
