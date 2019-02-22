package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/articles")
public class ArticleRestController {
    private ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(path="/all")
    public List<Article> getAllArticles() {
        return articleService.findAll();
    }

    @GetMapping(value = "/{articleId}")
    public Article getArticle(@PathVariable Long articleId) {
        return articleService.findById(articleId);
    }

    @DeleteMapping("/{articleId}")
    public void deleteById(@PathVariable("articleId") Long articleId) {
        articleService.deleteById(articleId);
    }

}
