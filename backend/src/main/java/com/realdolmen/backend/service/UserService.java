package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;

import java.util.List;

public interface UserService extends CrudService<User, Long> {

    <S extends User> S update (S user, S updatedUser);

    User create (User user);

    User findById(Long id);

    UserDto findByUserId(Long id);

    List<UserDto> getAllUsers();

    void deleteById(Long id);

    void delete(User user);
}
