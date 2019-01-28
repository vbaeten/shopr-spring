package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.repository.UserRepository;
import com.realdolmen.backend.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private UserServiceImpl userServiceImpl;

    public UserController( UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    @RequestMapping("/list")
      public List<User> getUsers() {
        return userServiceImpl.findAll();
    }

    @PostMapping
    @RequestMapping("/register")
    public User registerUser(@RequestBody User user) {
        userServiceImpl.save(user);
        return user;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userServiceImpl.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userServiceImpl.delete(id);
    }
}
