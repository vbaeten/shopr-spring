package com.realdolmen.backend.dao;

import com.realdolmen.backend.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingDao extends JpaRepository<Rating, Long>
{


}
