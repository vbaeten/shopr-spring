package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private ArticleService articleService;

    public ArticleController ( ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/list")
    public List<Article> getArticles() {
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable("id") Long id) { return articleService.findById(id);}

    @DeleteMapping("/delete/{id}")
    public void deleteArticleById(@PathVariable("id") Long id) {
        articleService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public void deleteArticle(Article article) {
        articleService.delete(article);
    }

}
