package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserMapperTest {

    public static final String FIRSTNAME = "Jutta";
    public static final String LASTNAME = "Roggen";
    UserMapper userMapper = UserMapper.INSTANCE;

    @Test
    public void userToUserDTO() throws Exception {
        //given
        User user = new User();
        user.setFirstName(FIRSTNAME);
        user.setName(LASTNAME);

        //when
        UserDto userDto = userMapper.userToUserDto(user);

        //then
        assertEquals(FIRSTNAME, userDto.getFirstName());
        assertEquals(LASTNAME, userDto.getName());
    }


}
