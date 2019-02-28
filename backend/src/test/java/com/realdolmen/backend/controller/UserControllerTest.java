package com.realdolmen.backend.controller;

import com.realdolmen.backend.facade.UserFacade;
import com.realdolmen.backend.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    UserService userService;
    @Mock
    UserFacade userFacade;

    @InjectMocks
    UserController controller;

    MockMvc mockMvc;


    @Test
    public void registerUser() {
    }

    @Test
    public void getUserById() {
    }


    @Test
    public void deleteUserById() {
    }

    @Test
    public void deleteUser() {
    }
}
