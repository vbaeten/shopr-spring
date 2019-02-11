package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.service.UserService;
import com.realdolmen.backend.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController( UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @GetMapping("/list")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        userService.create(user);
        return user;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public void deleteUser(User user) {
        userService.delete(user);
    }
}
