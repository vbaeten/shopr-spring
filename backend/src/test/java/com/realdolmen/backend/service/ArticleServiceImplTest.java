package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.repository.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceImplTest {

    @Mock
    private ArticleRepository articleRepository;
    @InjectMocks
    private ArticleServiceImpl articleServiceImpl;

    private Article article;

    @Test
    public void save() {
        Article article = articleServiceImpl.save(null);
        assertNull(article);
    }

    @Test
    public void delete() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void findAll() {
}}
