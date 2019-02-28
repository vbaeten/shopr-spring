package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.dto.ArticleDto;

public class ArticleTestDataBuilder {

    public static Article.Builder buildArticleFictionBook() {
        return Article.builder().id(1L).title("A book").price(50).supplier("Dreamland").type("FictionBook");
    }

    public static ArticleDto.Builder buildArticleFictionBookDto() {
        return ArticleDto.builder().id(1L).title("A book").price(50).supplier("Dreamland").type("FictionBook");
    }

}
