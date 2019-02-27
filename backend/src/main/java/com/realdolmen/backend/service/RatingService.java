package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Product;
import com.realdolmen.backend.domain.Rating;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.repository.ProductRepository;
import com.realdolmen.backend.repository.RatingRepository;
import com.realdolmen.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public RatingService(RatingRepository ratingRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public Rating save(Rating rating) {
        return ratingRepository.saveAndFlush(rating);
    }

    public void delete(Rating rating) {
        ratingRepository.delete(rating);
    }

    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    public Rating findRatingByUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(NullPointerException::new);
        return ratingRepository.findByUserOrderByRating(user);
    }

    public Rating findRatingByProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(NullPointerException::new);
        return ratingRepository.findByProductOrderByRating(product);
    }

}
