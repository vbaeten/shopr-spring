package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.Domain.User;
import com.realdolmen.backend.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserRestController {
    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{userId}")
    public User findById(@PathVariable("userId") Long userId) {
        return userRepository.getOne(userId);
    }

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PutMapping
    public void update(@RequestBody User user) {
        userRepository.findById(user.getUserId());
        userRepository.save(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable("userId") Long userId) {
        User user = findById(userId);
        userRepository.delete(user);
    }

}
