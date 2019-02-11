package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.Domain.Article;
import com.realdolmen.backend.repositories.ArticleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/articles")
public class ArticleRestController {
    private ArticleRepository articleRepository;

    public ArticleRestController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(path="/all")
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @GetMapping(value = "/{articleId}")
    public Article getArticle(@PathVariable Long articleId) {
        return articleRepository.getOne(articleId);
    }

    @DeleteMapping("/{articleId}")
    public void deleteById(@PathVariable("articleId") Long articleId) {
        Article article = getArticle(articleId);
        articleRepository.delete(article);
    }

}
