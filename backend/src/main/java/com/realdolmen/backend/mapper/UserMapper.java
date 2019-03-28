package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import org.modelmapper.ModelMapper;

public class UserMapper {
    private static ModelMapper modelMapper;

    private UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static UserDto convertUserToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
