package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Product;
import com.realdolmen.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/all")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }


}
