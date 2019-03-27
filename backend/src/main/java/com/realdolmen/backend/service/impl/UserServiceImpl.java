package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repositories.UserRepository;
import com.realdolmen.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long articleId) {
        return userRepository.findById(articleId).orElseThrow(NotFoundException::new);
    }

    @Override
    public <S extends User> S save(S entity) {
        return userRepository.save(entity);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName)
                .orElseThrow(NotFoundException::new);
    }
}
