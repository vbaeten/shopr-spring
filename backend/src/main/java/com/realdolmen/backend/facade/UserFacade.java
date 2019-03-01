package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.mapper.UserMapper;
import com.realdolmen.backend.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserFacade {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserFacade(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public List<UserDto> findUsers() {
        List<User> users = userService.findAll();
        return users
                .stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    public void delete(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        userService.delete(user);
    }

    public void deleteById(Long id) {
        User user = userService.findById(id);
        userService.deleteById(id);
    }

    public UserDto findById(Long id) {
        User user = userService.findById(id);
        return userMapper.userToUserDto(user);
    }

    public UserDto createUser(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        User savedUser = userService.save(user);
        return userMapper.userToUserDto(savedUser);
    }
}
