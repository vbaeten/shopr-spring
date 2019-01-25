package com.realdolmen.shoprbackend.controller;

import com.realdolmen.shoprbackend.domain.User;
import com.realdolmen.shoprbackend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        userService.save(user);
        return user;
    }

    @GetMapping(path = "/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }


    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll(){
        return userService.findAll();
    }


    @DeleteMapping
    public void delete(@RequestBody User user){
        userService.delete(user);
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
