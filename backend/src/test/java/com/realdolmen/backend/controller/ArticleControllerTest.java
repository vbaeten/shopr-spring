package com.realdolmen.backend.controller;

import com.realdolmen.backend.facade.ArticleFacade;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

public class ArticleControllerTest {

    @Mock
    ArticleFacade articleFacade;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getArticles() {
    }

    @Test
    public void getArticleById() throws Exception {
    }

    @Test
    public void deleteArticleById() {
    }

    @Test
    public void deleteArticle() {
    }
}
