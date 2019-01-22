package com.realdolmen.backend.repositories;

import com.realdolmen.backend.Domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
