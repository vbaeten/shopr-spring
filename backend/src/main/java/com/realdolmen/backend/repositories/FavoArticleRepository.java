package com.realdolmen.backend.repositories;

import com.realdolmen.backend.domain.FavoArticle;
import com.realdolmen.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoArticleRepository extends JpaRepository<FavoArticle, Long> {

    List<FavoArticle> findByUser(User user);
}
