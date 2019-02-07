package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Article;

import java.util.List;

public interface ArticleService extends CrudService<Article, Long> {

    Article findById(Long id);

    void deleteById(Long id);

    List<Article> findAll();

}
