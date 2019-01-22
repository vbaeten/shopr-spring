package com.realdolmen.backend.services;

import com.realdolmen.backend.dao.UserDao;
import com.realdolmen.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService
{
    @Autowired
    UserDao userDao;

    @Override
    public User findUserById(Long id)
    {
        return userDao.getOne(id);
    }

    @Override
    public User findUserByName(String name)
    {
        return null;
    }

    @Override
    public List<User> findAllUsers()
    {
        return null;
    }
}
