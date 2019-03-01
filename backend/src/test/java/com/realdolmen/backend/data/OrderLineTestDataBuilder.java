package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.dto.ArticleDto;
import com.realdolmen.backend.dto.OrderLineDto;

public class OrderLineTestDataBuilder {

    public static OrderLine.Builder buildOrderLine1() {
        Article article = ArticleTestDataBuilder.buildArticleFictionBook().build();
        return OrderLine.builder().id(1L).article(article).quantity(2);
    }

    public static OrderLine.Builder buildOrderLine2() {
        Article article = ArticleTestDataBuilder.buildArticleFictionBook().build();
        return OrderLine.builder().id(1L).article(article).quantity(1);
    }

    public static OrderLineDto.Builder buildOrderLine1Dto() {
        ArticleDto article = ArticleTestDataBuilder.buildArticleFictionBookDto().build();
        return OrderLineDto.builder().id(1L).article(article).quantity(2);
    }

    public static OrderLineDto.Builder buildOrderLine2Dto() {
        ArticleDto article = ArticleTestDataBuilder.buildArticleFictionBookDto().build();
        return OrderLineDto.builder().id(1L).article(article).quantity(1);
    }
}
