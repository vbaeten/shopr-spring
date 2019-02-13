package com.realdolmen.backend.controllers;

import com.realdolmen.backend.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderlineController
{

    private

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody @Valid User user)
    {
        System.out.println("save user");
        return userServiceImpl.save(user);
    }

}
