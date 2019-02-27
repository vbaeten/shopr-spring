package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.service.ArticleService;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ArticleControllerTest {

    @Mock
    ArticleService articleService;

    ArticleController controller;

//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        controller = new ArticleController(articleService);
//    }

    @Test
    public void getArticles() {
        List<Article> articles = new ArrayList<>();
        articles.add(new Article());
        articles.add(new Article());

        when(articleService.findAll()).thenReturn(articles);

        List<Article> items = articleService.findAll();

        assertEquals(articles, items);
    }

    @Test
    public void getArticleById() throws Exception {
        Article article = new Article();
        article.setId(1L);
        article.setTitle("Some Title");

        when(articleService.findById(any())).thenReturn(article);

        Article testArticle = articleService.findById(1L);

        assertEquals("Some Title", testArticle.getTitle());
    }

    @Test
    public void deleteArticleById() {
    }

    @Test
    public void deleteArticle() {
    }
}
