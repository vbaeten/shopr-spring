package com.realdolmen.backend.service;


import com.realdolmen.backend.domain.User;

public interface UserService extends CrudService<User, Long> {
    User findByUserName(String userName);
    void deleteById(Long id);
}
