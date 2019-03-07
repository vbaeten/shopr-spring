package com.realdolmen.backend.services;

import com.realdolmen.backend.dao.OrderlineDao;
import com.realdolmen.backend.model.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderlineServiceImpl
{
    private OrderlineDao orderlineDao;

    public OrderlineServiceImpl(OrderlineDao orderlineDao)
    {
        this.orderlineDao = orderlineDao;
    }

    public OrderLine save(OrderLine orderLine)
    {

        return orderlineDao.save(orderLine);
    }



}
