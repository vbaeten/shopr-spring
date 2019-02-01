package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.service.UserService;
import com.realdolmen.backend.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PutMapping
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        User user = findById(id);
        userService.delete(user);
    }




}
