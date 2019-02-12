package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.repository.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static com.realdolmen.backend.data.ArticleTestDataBuilder.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.contains;

@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceTests {

    @InjectMocks
    ArticleServiceImpl articleService;
    @Mock
    ArticleRepository articleRepository;

    @Test
    public void findAll() {

        List<Article> expectedArticles = Arrays.asList(
                buildGameArticleNFS().build(),
                buildLpArticle().build()
        );

        when(articleRepository.findAll()).thenReturn(expectedArticles);
        List<Article> foundArticles = this.articleService.findAll();

        verify(articleRepository, times(1)).findAll();
        assertEquals(2,foundArticles.size());
        assertThat(foundArticles, contains(expectedArticles.toArray()));

    }

}