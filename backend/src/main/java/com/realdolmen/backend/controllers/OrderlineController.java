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
    Article article = new Article();
    OrderFromShop currentOrder;

    public OrderlineController(OrderlineServiceImpl orderlineService, ArticleServiceImpl articleService)
    {
        this.orderlineService = orderlineService;
        this.articleService = articleService;
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

}
