package com.realdolmen.backend.controller;

import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.facade.UserFacade;
import com.realdolmen.backend.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    UserService userService;
    @Mock
    UserFacade userFacade;

    @InjectMocks
    UserController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new UserController(userFacade, userService);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void registerUser() {
    }

    @Test
    public void getUserById() {
        //given
        UserDto user1 = new UserDto();
        user1.setId(1L);
        user1.setFirstName("Mitch");
        user1.setName("DeMeulenaere");


    }

    @Test
    public void findAllUsers() throws Exception {
        UserDto user1 = new UserDto();
        user1.setFirstName("Ines");
        user1.setName("Van Gucht");

        UserDto user2 = new UserDto();
        user2.setFirstName("Jutta");
        user2.setName("Roggen");

        List<UserDto> userDtos = Arrays.asList(user1, user2);

        when(userService.getAllUsers()).thenReturn(userDtos);

    }

    @Test
    public void deleteUserById() {
    }

    @Test
    public void deleteUser() {
    }
}
