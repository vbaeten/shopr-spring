package com.realdolmen.backend.services;

import com.realdolmen.backend.dao.UserDao;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.model.User;
import com.realdolmen.backend.model.enums.UserRoleEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl
{
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao)
    {
        this.userDao = userDao;
    }

    public User findUserByLastName(String name)
    {
        return userDao.findOneByLastName(name);
    }


    public User findById(Long id)
    {
        return userDao.findById(id).orElseThrow(() -> new NotFoundException("user not found"));
    }

    public List<User> findAll()
    {
        return userDao.findAll();
    }

    public User save(User user)
    {
        user.setUserRoleEnum(UserRoleEnum.USER);
        return userDao.save(user);
    }
}
