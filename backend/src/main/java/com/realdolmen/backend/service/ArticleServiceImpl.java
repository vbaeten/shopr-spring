package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Override
    public Article findById(Long id) throws NotFoundException {
        return articleRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public void delete(Article article) {
        articleRepository.delete(article);
    }


}
