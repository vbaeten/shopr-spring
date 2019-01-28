package com.realdolmen.backend.services;

import com.realdolmen.backend.dao.ArticleDao;
import com.realdolmen.backend.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl
{
private ArticleDao articleDao;

    public List<Article> findAll()
    {
        return articleDao.findAll();
    }
}
