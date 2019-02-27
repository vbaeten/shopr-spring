package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.Product;
import com.realdolmen.backend.domain.Rating;
import com.realdolmen.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    Rating findByUserOrderByRating(User user);
    Rating findByProductOrderByRating(Product product);
}
