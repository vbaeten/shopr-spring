package com.realdolmen.backend.controller;

import com.realdolmen.backend.service.ArticleService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ArticleControllerTest {

    @Mock
    ArticleService articleService;

    ArticleController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new ArticleController(articleService);
    }

    @Test
    public void getArticles() {
    }

    @Test
    public void getArticle() {
    }

    @Test
    public void deleteArticleById() {
    }

    @Test
    public void deleteArticle() {
    }
}
