package com.realdolmen.shoprbackend.controller;

import com.realdolmen.shoprbackend.domain.User;
import com.realdolmen.shoprbackend.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    private UserService userService;


    @PostMapping
    public User createUser(User user){
        userService.save(user);
        return user;
    }

    @GetMapping
    public User findById(Long id){
        return userService.findById(id);
    }

    @GetMapping
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
