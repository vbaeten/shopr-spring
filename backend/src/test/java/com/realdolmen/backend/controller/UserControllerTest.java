package com.realdolmen.backend.controller;

import com.realdolmen.backend.facade.UserFacade;
import com.realdolmen.backend.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserControllerTest {

    @Mock
    UserService userService;
    @Mock
    UserFacade userFacade;

    UserController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new UserController(userFacade, userService);
    }

    @Test
    public void registerUser() {
    }

    @Test
    public void getUserById() {
    }

    @Test
    public void findAllUsers() {
    }

    @Test
    public void deleteUserById() {
    }

    @Test
    public void deleteUser() {
    }
}
