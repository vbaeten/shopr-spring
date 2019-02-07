package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Product;
import com.realdolmen.backend.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productService;

    public ProductController(ProductRepository productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/all")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProduct(@PathVariable("id") Long id) {
        return productService.findById(id).orElseThrow(NullPointerException::new);
    }

}
