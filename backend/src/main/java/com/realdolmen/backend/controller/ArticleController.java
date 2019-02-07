package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.service.ArticleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private ArticleServiceImpl articleServiceImpl;

    public ArticleController ( ArticleServiceImpl articleServiceImpl) {
        this.articleServiceImpl = articleServiceImpl;
    }

    @GetMapping("/list")
    public List<Article> getArticles() {
        return articleServiceImpl.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArticleById(@PathVariable("id") Long id) {
        articleServiceImpl.deleteById(id);
    }

    @DeleteMapping("/delete")
    public void deleteArticle(Article article) {
        articleServiceImpl.delete(article);
    }

}
