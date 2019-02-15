package com.realdolmen.shoprbackend.services;

import com.realdolmen.shoprbackend.domain.Review;
import com.realdolmen.shoprbackend.exception.NotFoundException;
import com.realdolmen.shoprbackend.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements CrudService<Review,Long> {

    private ReviewRepository reviewRepository;


    @Override
    public <S extends Review> S save(S entity) {
        return this.reviewRepository.save(entity);
    }

    @Override
    public Review findById(Long primaryKey) {
        return this.reviewRepository.findById(primaryKey)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Review> findAll() {
        return this.reviewRepository.findAll();
    }

    @Override
    public void delete(Review entity) {

    }

    public List<Review> findByItemId(Long id){
        return reviewRepository.findByItemId(id);
    }

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
}
