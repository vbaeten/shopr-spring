package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/{id")
    public Article findById(@PathVariable("id") Long id) {
        return articleService.findById(id);
    }

    @GetMapping
    public List<Article> findAll(){
        return articleService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        Article article = findById(id);
        articleService.delete(article);
    }
}
