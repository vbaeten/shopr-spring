package com.realdolmen.backend.mapper;

import com.realdolmen.backend.data.UserTestDataBuilder;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserMapperTest {

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void userToUserDTO() throws Exception {
        User user = UserTestDataBuilder.buildUserBernadetteSanz().build();
        UserDto userDto = userMapper.userToUserDto(user);

        assertEquals(user.getFirstName(), userDto.getFirstName());
        assertEquals(user.getId(), userDto.getId());
    }

    @Test
    public void userDtoToUser() throws Exception {
        UserDto userDto = UserTestDataBuilder.buildUserDtoJuttaRoggen().build();
        User user = userMapper.userDtoToUser(userDto);

        assertEquals(userDto.getFirstName(), user.getFirstName());
        assertEquals(userDto.getName(), user.getName());
    }

    @Test
    public void testUserShouldAssertNull() {
        User user = userMapper.userDtoToUser(null);
        assertNull(user);
    }
    @Test
    public void testUserDtoShouldAssertNull() {
        UserDto userDto = userMapper.userToUserDto(null);
        assertNull(userDto);
    }
}
