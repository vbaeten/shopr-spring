package com.realdolmen.backend.controllers;

import com.realdolmen.backend.model.Article;
import com.realdolmen.backend.model.OrderFromShop;
import com.realdolmen.backend.model.OrderLine;
import com.realdolmen.backend.services.ArticleServiceImpl;
import com.realdolmen.backend.services.OrderlineServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderlineController
{

    private OrderlineServiceImpl orderlineService;
    private ArticleServiceImpl articleService;
    private OrderFromShopSer orderFromShop;
    Article article = new Article();

    public OrderlineController(OrderlineServiceImpl orderlineService, ArticleServiceImpl articleService, OrderFromShop orderFromShop)
    {
        this.orderlineService = orderlineService;
        this.articleService = articleService;
        this.orderFromShop = orderFromShop;
    }

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderLine save(@RequestBody @Valid OrderLine orderLine)
    {
//        if (currentOrder == null) currentOrder = new OrderFromShop();
        article = articleService.findById((long) orderLine.getArticleid());
        orderLine.setArticle(article);
        orderLine.setPriceOrderDate(article.getPrice());

        return orderlineService.save(orderLine);

    }

    @PostMapping(path = "/saveorder", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderFromShop save(@RequestBody @Valid OrderFromShop order)
    {
        return
    }

}
