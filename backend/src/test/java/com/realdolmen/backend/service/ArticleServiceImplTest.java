package com.realdolmen.backend.service;

import com.realdolmen.backend.data.ArticleTestDataBuilder;
import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.repository.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceImplTest {

    @Mock
    private ArticleRepository articleRepository;
    @InjectMocks
    private ArticleServiceImpl articleServiceImpl;

    private Article article;

    @Test
    public void save() {
        Article expectedArticle = ArticleTestDataBuilder.buildArticleFictionBook().build();

        when(articleRepository.save(any())).thenReturn(expectedArticle);

        Article savedArticle = this.articleServiceImpl.save(expectedArticle);

        verify(articleRepository, times(1)).save(expectedArticle);
        assertEquals(expectedArticle, savedArticle);
    }

    @Test
    public void delete() {
        Article article = ArticleTestDataBuilder.buildArticleFictionBook().build();
        articleServiceImpl.delete(article);

        verify(articleRepository, times(1)).delete(article);
    }

    @Test
    public void findById() {
        Article expectedArticle = ArticleTestDataBuilder.buildArticleFictionBook().build();
        when(articleRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(expectedArticle));
        Article foundArticle = this.articleServiceImpl.findById(1L);

        verify(articleRepository, times(1)).findById(1L);
        assertEquals(expectedArticle.getType(), foundArticle.getType());
        assertEquals(expectedArticle.getId(), foundArticle.getId());
    }

    @Test
    public void deleteById() {
        Article expectedArticle = ArticleTestDataBuilder.buildArticleFictionBook().build();

        articleServiceImpl.deleteById(1L);

        verify(articleRepository, times(1)).deleteById(1L);
    }

    @Test
    public void findAll() {
        List<Article> expectedArticles = new ArrayList<>();
        Article article1 = ArticleTestDataBuilder.buildArticleFictionBook().build();
        expectedArticles.add(article1);

        when(articleRepository.findAll()).thenReturn(expectedArticles);

        List<Article> foundArticles = this.articleServiceImpl.findAll();

        verify(articleRepository, times(1)).findAll();
        assertEquals(expectedArticles.size(), foundArticles.size());
}}
