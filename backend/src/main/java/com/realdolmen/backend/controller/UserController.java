package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userServiceImpl;

    public UserController( UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/list")
    public List<User> getUsers() {
        return userServiceImpl.findAll();
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        userServiceImpl.save(user);
        return user;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userServiceImpl.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userServiceImpl.deleteById(id);
    }

    @DeleteMapping("/delete")
    public void deleteUser(User user) {
        userServiceImpl.delete(user);
    }
}
