package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Article;

import java.util.List;

public interface ArticleService {

    Article findById(Long id);

    List<Article> findAll();

    void delete(Article article);
}
