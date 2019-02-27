package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.dto.ArticleDto;
import com.realdolmen.backend.facade.ArticleFacade;
import com.realdolmen.backend.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private ArticleService articleService;
    private ArticleFacade articleFacade;

    public ArticleController ( ArticleService articleService, ArticleFacade articleFacade) {
        this.articleService = articleService;
        this.articleFacade = articleFacade;
    }

    @GetMapping("/list")
    public List<ArticleDto> getArticles() {
        return articleFacade.findArticles();
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable("id") Long id) { return articleService.findById(id);}

    @DeleteMapping("/delete/{id}")
    public void deleteArticleById(@PathVariable("id") Long id) {
        articleService.deleteById(id);
    }

//    @DeleteMapping("/delete")
//    public void deleteArticle(Article article) {
//        articleService.delete(article);
//    }

    @DeleteMapping("/delete")
    public void deleteArticle(ArticleDto articleDto) {
        articleFacade.delete(articleDto);
    }

}
