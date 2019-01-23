package com.realdolmen.backend.services;

import com.realdolmen.backend.dao.UserDao;
import com.realdolmen.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl
{
    @Autowired
    UserDao userDao;


    public User findUserByLastName(String name)
    {
        return userDao.findOneByLastName(name);
    }


}
