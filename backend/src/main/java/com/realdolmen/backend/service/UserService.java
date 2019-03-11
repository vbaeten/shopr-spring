package com.realdolmen.backend.service;


import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.exceptions.NotFoundException;

public interface UserService extends CrudService<User, Long> {
    User findByUserName(String userName) throws NotFoundException;

    void deleteById(Long id);
}
