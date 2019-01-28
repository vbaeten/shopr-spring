package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.facade.UserFacade;
import com.realdolmen.backend.facade.UserFacadeImpl;
import com.realdolmen.backend.service.UserService;
import com.realdolmen.backend.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public User save(User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @DeleteMapping
    public void delete(User user) {
        userService.delete(user);
    }



//    @GetMapping("/users")
//    public List<UserDto> findAll(){
//        return userFacade.findAll();
//    }


}
