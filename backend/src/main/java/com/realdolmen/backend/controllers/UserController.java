package com.realdolmen.backend.controllers;

import com.realdolmen.backend.model.User;
import com.realdolmen.backend.services.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    private UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl)
    {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllComponents()
    {
        return userServiceImpl.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public User getOneForId(@PathVariable Long id)
    {
        return userServiceImpl.findById(id);
    }

    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody @Valid User user)
    {
        System.out.println("save user");
        return userServiceImpl.save(user);
    }



}
