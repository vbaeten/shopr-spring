package com.realdolmen.shoprbackend.repository;


import com.realdolmen.shoprbackend.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findByItemId(Long Id);
}
