package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.exceptions.NotFoundException;

import java.util.List;

public interface ArticleService {

    Article findById(Long id) throws NotFoundException;

    List<Article> findAll();

    void delete(Article article);


}
