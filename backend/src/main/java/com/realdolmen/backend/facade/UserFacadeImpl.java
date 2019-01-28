package com.realdolmen.backend.facade;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.mapper.UserMapper;
import com.realdolmen.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class UserFacadeImpl implements UserFacade {

    private final UserMapper userMapper;
    private final UserService userService;


//    private List<User> users = new ArrayList<>();

    public UserDto findById(Long id){
        User user = userService.findById(id);
        return userMapper.userToUserDto(user);
    }

//    public List<UserDto> findAll(){
//        users = userService.findAll();
//        return userMapper.usersToUserDtos(users);
//    }


}
