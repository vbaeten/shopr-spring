package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Override
    public <S extends Article> S save(S entity) {
        return null;
    }

    @Override
    public void delete(Article entity) {

    }

    @Override
    public Article findById(Long id) {
        return null;
    }

    @Override
    public Article delete(Long id) {
        return null;
    }

    @Override
    public List<Article> findAll() {
        return null;
    }
}
