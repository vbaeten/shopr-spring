package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.dto.ArticleDto;
import org.modelmapper.ModelMapper;

public class ArticleMapper {
    private static ModelMapper modelMapper;

    private ArticleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static ArticleDto convertArticleToDto(Article article) {
        return modelMapper.map(article, ArticleDto.class);
    }
}
