package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.facade.UserFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody @Valid UserDto userDto) {
        return new ResponseEntity<>(userFacade.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userFacade.findById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<UserDto> findAllUsers() {
        return userFacade.findUsers();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userFacade.deleteById(id);
    }

    @DeleteMapping("/delete")
    public void deleteUser(UserDto userDto) {
        userFacade.delete(userDto);
    }

}
