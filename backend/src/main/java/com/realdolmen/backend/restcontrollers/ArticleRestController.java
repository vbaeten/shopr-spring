package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.dto.ArticleDto;
import com.realdolmen.backend.mapper.ArticleMapper;
import com.realdolmen.backend.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/articles")
@AllArgsConstructor
public class ArticleRestController {

    private ArticleService articleService;


    @GetMapping(path = "/all")
    public List<ArticleDto> getAllArticles() {
        return articleService.findAll().stream()
                .map(ArticleMapper::convertArticleToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{articleId}")
    public ArticleDto getArticle(@PathVariable Long articleId) {
        return ArticleMapper.convertArticleToDto(articleService.findById(articleId));
    }

    @DeleteMapping("/{articleId}")
    public void deleteById(@PathVariable("articleId") Long articleId) {
        articleService.deleteById(articleId);
    }

}
