package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repositories.ArticleRepository;
import com.realdolmen.backend.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article findById(Long id) {
        return this.articleRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public <S extends Article> S save(S entity) {
        return articleRepository.save(entity);
    }

}
