package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.dto.ArticleDto;
import com.realdolmen.backend.mapper.ArticleMapper;
import com.realdolmen.backend.service.ArticleService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleFacade {

    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    public ArticleFacade(ArticleService articleService, ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
    }

    public List<ArticleDto> findArticles() {
        List<Article> articles = articleService.findAll();
        return  articles
                .stream()
                .map(articleMapper::articleToArticleDto)
                .collect(Collectors.toList());
    }

    public ArticleDto findById(Long id) {
        Article article = articleService.findById(id);
        return articleMapper.articleToArticleDto(article);
    }

    public void deleteById(Long id) {
        articleService.deleteById(id);
    }

    public void deleteArticle(ArticleDto articleDto) {
        Article article = articleMapper.articleDtoToArticle(articleDto);
        articleService.delete(article);
    }

}
