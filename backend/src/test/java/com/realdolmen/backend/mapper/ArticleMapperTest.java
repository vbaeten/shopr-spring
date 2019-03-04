package com.realdolmen.backend.mapper;

import com.realdolmen.backend.data.ArticleTestDataBuilder;
import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.dto.ArticleDto;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArticleMapperTest {

    private ArticleMapper articleMapper = Mappers.getMapper(ArticleMapper.class);

    @Test
    public void articleToUserDTO() throws Exception {
        Article article = ArticleTestDataBuilder.buildArticleFictionBook().build();
        ArticleDto articleDto = articleMapper.articleToArticleDto(article);

        assertEquals(article.getPrice(), articleDto.getPrice(), 0.05);
        assertEquals(article.getId(), articleDto.getId());
    }

    @Test
    public void articleDtoToArticle() throws Exception {
        ArticleDto articleDto = ArticleTestDataBuilder.buildArticleFictionBookDto().build();
        Article article = articleMapper.articleDtoToArticle(articleDto);

        assertEquals(articleDto.getSupplier(), article.getSupplier());
        assertEquals(articleDto.getId(), article.getId());
    }

    @Test
    public void testArticleShouldAssertNull() {
        Article article = articleMapper.articleDtoToArticle(null);
        assertNull(article);
    }
    @Test
    public void testArticleDtoShouldAssertNull() {
        ArticleDto articleDto = articleMapper.articleToArticleDto(null);
        assertNull(articleDto);
    }

}
