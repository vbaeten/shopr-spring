package com.realdolmen.backend.services;

import com.realdolmen.backend.dao.ArticleDao;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl
{
private ArticleDao articleDao;

    public ArticleServiceImpl(ArticleDao articleDao)
    {
        this.articleDao = articleDao;
    }

    public List<Article> findAll()
    {
        return articleDao.findAll();
    }

    public Article findById(Long id)
    {
        return articleDao.findById(id).orElseThrow(() -> new NotFoundException("article not found"));
    }

}
