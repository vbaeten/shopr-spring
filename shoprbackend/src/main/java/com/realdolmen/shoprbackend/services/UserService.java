package com.realdolmen.shoprbackend.services;


import com.realdolmen.shoprbackend.domain.User;
import com.realdolmen.shoprbackend.exception.NotFoundException;
import com.realdolmen.shoprbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements CrudService<User,Long> {

    private final UserRepository userRepository;



    @Override
    public <S extends User> S save(S user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(User user) {

        userRepository.delete(user);
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
