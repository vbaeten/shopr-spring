package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.repository.ArticleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceImplTest {

    @Mock
    private ArticleRepository articleRepository;
    @InjectMocks
    private ArticleServiceImpl articleServiceImpl;

    @Before
    public void setUp() {
    }

    @Test
    public void save() {
        Article article = articleServiceImpl.save(null);
        assertNull(article);
    }

    @Test
    public void delete() {
        Article expectedArticle = new Article("title", 55, "Dreamland");

        doNothing()
                .when(articleRepository).delete(expectedArticle);

        articleServiceImpl.delete(expectedArticle);

        verify(articleRepository, times(1)).delete(expectedArticle);
    }

    @Test
    public void findById() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void findAll() {
        List<Article> expectedArticles = Arrays.asList(
                new Article("title", 55, "Dreamland"),
                new Article("title2", 55, "Dreamland")
        );

        when(articleRepository.findAll())
                .thenReturn(expectedArticles);

        List<Article> actualArticles = articleServiceImpl.findAll();

        verify(articleRepository, times(1)).findAll();
        assertEquals(expectedArticles.size(), actualArticles.size());
        assertThat(actualArticles, contains(expectedArticles.toArray()));
    }
}
