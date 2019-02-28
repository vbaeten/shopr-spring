package com.realdolmen.backend.facade;

import com.realdolmen.backend.data.UserTestDataBuilder;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.mapper.UserMapper;
import com.realdolmen.backend.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserFacadeTest {

    @InjectMocks
    private UserFacade userFacade;

    @Mock
    private UserService userService;
    @Mock
    private UserMapper userMapper;

    private User user;



    @Before
    public void setUp() throws Exception {
        user = UserTestDataBuilder.buildUserBernadetteSanz().build();
    }

    @Test
    public void findUsers() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void findById() throws Exception {
        UserDto userDto = UserTestDataBuilder.buildUserDtoBernadetteSanz().build();

        when(userService.findById(1L)).thenReturn(user);
        when(userMapper.userToUserDto(user)).thenReturn(userDto);

        UserDto userDtoResult;
        userDtoResult = userFacade.findById(1L);

        assertNotNull(userDtoResult);
        assertEquals("Bernadette", userDtoResult.getFirstName());
    }

    @Test
    public void createUser() {
        UserDto userDto = UserTestDataBuilder.buildUserDtoBernadetteSanz().build();

    }
}
