package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.service.ArticleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/article")
public class ArticleController {

    private final ArticleServiceImpl articleService;

    @PostMapping
    public Article save(@RequestBody Article article) {
        return articleService.save(article);
    }

    @GetMapping("/{id}")
    public Article findById(@PathVariable Long id) {
        return articleService.findById(id);
    }

    @GetMapping
    public List<Article> findAll(){
        return articleService.findAll();
    }

    @DeleteMapping
    public void delete(Article article) {
        articleService.delete(article);
    }

}
