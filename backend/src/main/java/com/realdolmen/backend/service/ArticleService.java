package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Article;

import java.util.List;

public interface ArticleService {

    Article findById(Long id);

    Article delete(Article article);

    List<Article> findAll();

}
