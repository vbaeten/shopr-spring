package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.facade.UserFacade;
import com.realdolmen.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserFacade userFacade;
    private UserService userService;

    public UserController(UserFacade userFacade, UserService userService) {
        this.userFacade = userFacade;
        this.userService = userService;
    }

    @PostMapping("/reg")
    @ResponseStatus(HttpStatus.OK)
    public User registerUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUserByDto(@RequestBody UserDto userDto) {
        return new ResponseEntity<UserDto>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        return new ResponseEntity<UserDto>(userService.findByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<UserDto> findAllUsers() {
        return userFacade.findUsers();
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
