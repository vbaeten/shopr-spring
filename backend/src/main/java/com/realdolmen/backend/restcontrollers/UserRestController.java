package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.mapper.UserMapper;
import com.realdolmen.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/user")
public class UserRestController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserRestController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto save(@RequestBody @Valid User user) {
        return userMapper.convertUserToDto(userService.save(user));
    }

    @GetMapping("/{userId}")
    public User findById(@PathVariable("userId") Long userId) {
        return userService.findById(userId);
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll().stream().map(userMapper::convertUserToDto).collect(Collectors.toList());
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
    public UserDto registerUser(@RequestBody User user) {
        return userMapper.convertUserToDto(userService.save(user));
    }


    @PostMapping(path = "/login/")
    public UserDto login(@RequestBody String userName) {
        return userMapper.convertUserToDto(userService.findByUserName(userName));
    }


}
