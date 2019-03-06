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
import static org.mockito.Mockito.*;

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
        this.userFacade.findUsers();
        verify(userService, times(1)).findAll();
    }

    @Test
    public void delete() {
        UserDto userDto = UserTestDataBuilder.buildUserDtoBernadetteSanz().build();
        userFacade.delete(userDto);

        verify(userService, times(1)).delete(any());
    }

    @Test
    public void deleteById() {
        userFacade.deleteById(any());

        verify(userService, times(1)).deleteById(any());
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

        verify(userService, times(1)).findById(any());
    }

    @Test
    public void createUser() {
        UserDto userDto = UserTestDataBuilder.buildUserDtoBernadetteSanz().build();
        userFacade.createUser(userDto);

        verify(userService, times(1)).save(any());
    }
}
