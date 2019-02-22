package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.mapper.UserMapper;
import com.realdolmen.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public <S extends User> S update(S user, S updatedUser) {
        return null;
    }

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
    public UserDto findByUserId(Long id) {
        return userRepository.findById(id).map(userMapper::userToUserDto).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserDto userDto = userMapper.userToUserDto(user);
    //TODO see udemy section 24, lecture 390 userDto.setUserUrl("api/user/" + user.getId());
            return userDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}


