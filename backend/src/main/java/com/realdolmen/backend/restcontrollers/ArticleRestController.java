package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.Domain.Article;
import com.realdolmen.backend.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/articles")
public class ArticleRestController {
    private ArticleRepository articleRepository;

    public ArticleRestController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(path="/all")
    public @ResponseBody
    List<Article> getAllArticles(){
        return articleRepository.findAll();
    }
}
