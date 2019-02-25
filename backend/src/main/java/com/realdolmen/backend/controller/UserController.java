package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

//    @GetMapping("//{id}")
//    public User findByOrderId(@PathVariable("id") Long id) {
//        return userService.findByOrderId(id);
//    }

    @GetMapping("/{userName}")
    public User findByUserName(@PathVariable("userName") String userName) {
        return userService.findByUserName(userName);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

//    @PutMapping
//    public void update(@RequestBody User user){
//        userService.update(user);
//    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }


}
