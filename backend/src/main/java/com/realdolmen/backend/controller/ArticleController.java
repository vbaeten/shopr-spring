package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.ArticleDto;
import com.realdolmen.backend.facade.ArticleFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private ArticleFacade articleFacade;

    public ArticleController ( ArticleFacade articleFacade) {
        this.articleFacade = articleFacade;
    }

    @GetMapping("/list")
    public List<ArticleDto> getArticles() {
        return articleFacade.findArticles();
    }

    @GetMapping("/{id}")
    public ArticleDto getArticle(@PathVariable("id") Long id) { return articleFacade.findById(id);}

    @DeleteMapping("/delete/{id}")
    public void deleteArticleById(@PathVariable("id") Long id) {
        articleFacade.deleteById(id);
    }

    @DeleteMapping("/delete")
    public void deleteArticle(ArticleDto articleDto) {
        articleFacade.deleteArticle(articleDto);
    }

}
