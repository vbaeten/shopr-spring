package com.realdolmen.backend.controllers;

import com.realdolmen.backend.dao.UserDao;
import com.realdolmen.backend.model.User;
import com.realdolmen.backend.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class UserController
{
    @Autowired
    UserDao userDao;

    @Autowired
    UserServiceImpl userServiceImpl;


    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllComponents()
    {
        return (List<User>) userDao.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getOneForId(@PathVariable Long id)
    {
        Optional<User> user;
        user = userDao.findById(id);

//        user.setFirstName("test");
//        user.setLastName("test2");

        return user;
//        return userDao.getOne(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody @Valid User user){
        return userDao.save( user);
    }






}
