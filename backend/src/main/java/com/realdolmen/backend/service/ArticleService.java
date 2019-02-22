package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService extends CrudService<Article, Long> {

    Article findById(Long id);

    void deleteById(Long id);

    List<Article> findAll();
}
