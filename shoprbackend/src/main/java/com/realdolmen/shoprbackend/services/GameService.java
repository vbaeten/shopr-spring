package com.realdolmen.shoprbackend.services;

import com.realdolmen.shoprbackend.domain.User;
import com.realdolmen.shoprbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GameService implements CrudService<User, Long> {

    private final UserRepository userRepository;



    @Override
    public <S extends User> S save(S entity) {
        return userRepository.save(entity);
    }

    @Override
    public User findById(Long primaryKey) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void delete(User entity) {

    }



    public GameService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
