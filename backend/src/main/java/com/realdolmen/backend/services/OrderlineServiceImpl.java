package com.realdolmen.backend.services;

import com.realdolmen.backend.dao.ArticleDao;
import com.realdolmen.backend.dao.OrderFromShopDao;
import com.realdolmen.backend.dao.OrderlineDao;
import com.realdolmen.backend.model.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderlineServiceImpl
{
    private OrderlineDao orderlineDao;
    private OrderFromShopDao orderFromShopDao;
    private ArticleDao articleDao;


    public OrderlineServiceImpl(OrderlineDao orderlineDao, OrderFromShopDao orderFromShopDao, ArticleDao articleDao)
    {
        this.orderlineDao = orderlineDao;
        this.orderFromShopDao = orderFromShopDao;
        this.articleDao = articleDao;
    }

    public OrderLine save(OrderLine orderLine)
    {
        orderLine.setArticle(articleDao.getOne((long) orderLine.getArticleid()));

        return orderlineDao.save(orderLine);
    }


}
