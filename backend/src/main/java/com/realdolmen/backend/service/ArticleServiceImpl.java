package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public <S extends Article> S save(S entity) {
        return null; //TODO fix this
    }

    @Override
    public void delete(Article article) {
        articleRepository.delete(article);
    }

    @Override
    public Article findById(Long id) {
        return articleRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
