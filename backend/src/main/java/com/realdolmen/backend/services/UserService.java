package com.realdolmen.backend.services;

import com.realdolmen.backend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService
{
    User findUserById(Long id);
    User findUserByName(String name);
    List<User> findAllUsers();


}
