package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Article;

import java.util.List;

public interface ArticleService extends CrudService<Article, Long> {

    Article findById(Long id);

    Article delete(Long id);

    List<Article> findAll();

}
