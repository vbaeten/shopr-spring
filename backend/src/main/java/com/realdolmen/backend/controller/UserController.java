package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> checkIfUserAlreadyExist(@PathVariable("userName") String userName) {
        try {
            User user = userService.findByUserName(userName);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(user);
        } catch (Exception e) {
            return ResponseEntity.ok().build();
        }
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
