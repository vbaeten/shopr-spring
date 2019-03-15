package com.realdolmen.backend.services;

import com.realdolmen.backend.dao.OrderFromShopDao;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.model.OrderFromShop;
import org.springframework.stereotype.Service;

@Service
public class OrderFromShopServiceImpl
{
    private OrderFromShopDao orderFromShopDao;

    public OrderFromShopServiceImpl(OrderFromShopDao orderFromShopDao)
    {
        this.orderFromShopDao = orderFromShopDao;
    }

    public OrderFromShop save(OrderFromShop orderFromShop)
    {
        return orderFromShopDao.save(orderFromShop);
    }

    public OrderFromShop findById(long Id)
    {

        return orderFromShopDao.findById(Id).orElseThrow(() -> new NotFoundException("lp not found"));
    }

}
