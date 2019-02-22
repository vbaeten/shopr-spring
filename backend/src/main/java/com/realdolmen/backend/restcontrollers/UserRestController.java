package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody @Valid User user) {
        return userService.save(user);
    }

    @GetMapping("/{userId}")
    public User findById(@PathVariable("userId") Long userId) {
        return userService.findById(userId);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PutMapping
    public void update(@RequestBody @Valid User user) {
        userService.findById(user.getUserId());
        userService.save(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable("userId") Long userId) {
        userService.deleteById(userId);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.save(user);
    }


    @PostMapping(path = "/login/")
    public User login(@RequestBody String userName) {
        return userService.findByUserName(userName).orElseThrow(NotFoundException::new);

    }


}
