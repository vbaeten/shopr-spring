package com.realdolmen.backend.controllers;

import com.realdolmen.backend.model.Article;
import com.realdolmen.backend.model.Fiction;
import com.realdolmen.backend.services.ArticleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController
{
    private ArticleServiceImpl articleService;

    public ArticleController(ArticleServiceImpl articleService)
    {
        this.articleService = articleService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Article> getAllArticles()
    {
        return articleService.findAll();
    }

}
