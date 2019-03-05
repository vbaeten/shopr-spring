package com.realdolmen.backend.facade;

import com.realdolmen.backend.data.ArticleTestDataBuilder;
import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.dto.ArticleDto;
import com.realdolmen.backend.mapper.ArticleMapper;
import com.realdolmen.backend.service.ArticleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleFacadeTest {

    @InjectMocks
    private ArticleFacade articleFacade;

    @Mock
    private ArticleService articleService;
    @Mock
    private ArticleMapper articleMapper;

    private Article article;

    @Before
    public void setUp() throws Exception {
        article = ArticleTestDataBuilder.buildArticleFictionBook().build();
    }

    @Test
    public void findArticles() {
        this.articleFacade.findArticles();
        verify(articleService, times(1)).findAll();
    }

    @Test
    public void findById() {
        ArticleDto articleDto = ArticleTestDataBuilder.buildArticleFictionBookDto().build();

        when(articleService.findById(1L)).thenReturn(article);
        when(articleMapper.articleToArticleDto(article)).thenReturn(articleDto);

        ArticleDto articleDtoResult;
        articleDtoResult = articleFacade.findById(1L);

        assertNotNull(articleDtoResult);
        assertEquals(articleDto.getTitle(), articleDtoResult.getTitle());

        verify(articleService, times(1)).findById(any());
    }

    @Test
    public void delete() {
        ArticleDto articleDto = ArticleTestDataBuilder.buildArticleFictionBookDto().build();
        articleFacade.deleteArticle(articleDto);

        verify(articleService, times(1)).delete(any());
    }

    @Test
    public void deleteById() {
        articleFacade.deleteById(any());

        verify(articleService, times(1)).deleteById(any());
    }
}
