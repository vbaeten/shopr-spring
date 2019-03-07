package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends CrudService<User, Long> {

    User findById(Long id);

    List<User> findAll();

    User create(User user);

    void deleteById(Long id);

    User findByUserName(String userName);


}

