package com.realdolmen.shoprbackend.controller;

import com.realdolmen.shoprbackend.domain.Review;
import com.realdolmen.shoprbackend.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;


    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Review> findAllById(@PathVariable Long id){
        return reviewService.findByItemId(id);
    }

    @PostMapping
    public void addReview(@RequestBody Review review){
        this.reviewService.save(review);
    }


    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
}
