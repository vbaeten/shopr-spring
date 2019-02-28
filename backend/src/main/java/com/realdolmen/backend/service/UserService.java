package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.User;

public interface UserService extends CrudService<User, Long> {

    User create (User user);

    User findById(Long id);

    void deleteById(Long id);

    void delete(User user);
}
