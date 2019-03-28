package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleMapper {
    private final ModelMapper modelMapper;

    public ArticleDto convertArticleToDto(Article article) {
        return modelMapper.map(article, ArticleDto.class);
    }
}
