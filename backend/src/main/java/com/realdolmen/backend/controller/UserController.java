package com.realdolmen.backend.controller;

import com.realdolmen.backend.domain.PrincipalUser;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.FoundUserDto;
import com.realdolmen.backend.service.UserService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<FoundUserDto> registerUser(@RequestBody User newUser) {
        try {
            userService.findByUsername(newUser.getUsername());
        } catch(NotFoundException exception) {
            User user = userService.create(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(convertToFoundUserDto(user));
        }
       return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    private FoundUserDto convertToFoundUserDto(User user) {
        FoundUserDto foundUserDto = new FoundUserDto();
        foundUserDto.setFirstName(user.getFirstname());
        foundUserDto.setUserName(user.getUsername());
        foundUserDto.setId(user.getId());
        return foundUserDto;
    }


    @RequestMapping("/currentuser")
    @ResponseBody
    public Principal user(HttpServletRequest request) throws NotFoundException {
        PrincipalUser principalUser = new PrincipalUser();
        principalUser.setName(SecurityContextHolder.getContext().getAuthentication().getName());
        principalUser.setRoles(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        principalUser.setId(userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getId());
        return principalUser;
    }

//
//    @RequestMapping(value = "/userid", method = RequestMethod.GET)
//    @ResponseBody
//    public PrincipalUser currentUserId() throws NotFoundException {
//        PrincipalUser principalUser = new PrincipalUser();
//        principalUser.setName(SecurityContextHolder.getContext().getAuthentication().getName());
//        principalUser.setRoles(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
//        principalUser.setId(userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getId());
//        return principalUser;
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity exception() {
        return ResponseEntity.ok().body(null);
    }


}
