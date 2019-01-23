package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.User;

public interface UserService extends CrudService<User, Long> {

    <S extends User> S update (S user, S updatedUser);
    User create (User user);

}
