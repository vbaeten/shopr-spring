package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.dto.ArticleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    ArticleDto articleToArticleDto(Article article);

    Article articleDtoToArticle(ArticleDto articleDto);

}
