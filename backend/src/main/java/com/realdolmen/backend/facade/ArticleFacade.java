package com.realdolmen.backend.facade;

import com.realdolmen.backend.mapper.ArticleMapper;
import com.realdolmen.backend.service.ArticleService;
import org.springframework.stereotype.Component;

@Component
public class ArticleFacade {

    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    public ArticleFacade(ArticleService articleService, ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
    }


}
